package game;

import edu.monash.fit2099.engine.*;


import java.util.ArrayList;


public abstract class Dinosaur extends Actor {




    /**
     * private attribute of type integer, specifies the starting food level a Dinosaur
     */
    private int foodLevel = 50;

    /**
     * private attribute of type integer, specifies the starting water level a Dinosaur
     */
    private int waterLevel = 60;

    /**
     *  private attribute of type boolean, randomly generates the gender of a Dinosaur
     */
    private boolean male = (Math.random() < 0.5);

    /**
     *  private attribute of type integer, used to count how long a dinosaur is unconscious for (if it is unconscious)
     */
    private int unconsciousCounter = 0;

    /**
     *  private attribute of type boolean, sets the initial pregnant value to false 
     * used to remember if a dinosaur of a female type is pregnant and should deliver an egg soon.
     */
    private boolean pregnant = false;

    /**
     *  private attribute of type integer, used to check if a pregnant dinosaur should deliver an egg.
     * Incremented on every playTurn if the dinosaur instance is pregnant
     */
    private int pregnantCounter= 0;

    /**
     * protected ArrayList of behaviours. Used to allow a dinosaur to cycle between different allowable behaviours and get an appropriate action 
     * at an appropriate time based on its current state and location
     */
    protected ArrayList<Behaviour> behaviour = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    protected Dinosaur(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);



        if(this instanceof Stegosaur ) {
            behaviour.add(new BreedBehaviour());
            behaviour.add(new HerbivoreBehaviour());
            behaviour.add(new WanderBehaviour());
        }
        else if(this instanceof Allosaur){
            behaviour.add(new BreedBehaviour());
            behaviour.add(new HuntBehaviour());
            behaviour.add(new CarnivoreBehaviour());
            behaviour.add(new WanderBehaviour());
        }
        else if(this instanceof Brachiosaur) {
            behaviour.add(new BreedBehaviour());
            behaviour.add(new HerbivoreBehaviour());
            behaviour.add(new WanderBehaviour());
        }
        else if(this instanceof Pterodactyls){
            behaviour.add(new BreedBehaviour());
            behaviour.add(new PterodactylsBehaviour());
            behaviour.add(new WanderBehaviour());
        }

        else if(this instanceof BabyDinosaur){
            if(this instanceof BabyStegosaur){
                behaviour.add(new HerbivoreBehaviour());
            }
            else if(this instanceof BabyAllosaur){
                behaviour.add(new CarnivoreBehaviour());
            }
            else if(this instanceof BabyBrachiosaur){
                behaviour.add(new HerbivoreBehaviour());
            }
            else if(this instanceof BabyPterodactyls){
                behaviour.add(new PterodactylsBehaviour());
            }
            behaviour.add(new WanderBehaviour());
        }
    }



    /**
     * Returns a collection of the Actions that the otherActor can do to the current Actor.
     * It specifically collects AttackAction and FeedAction for a specific actor.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions actions = new Actions();
        actions.add(new AttackAction(this));


        for(Item item:otherActor.getInventory()){

            if (item instanceof Feedable) 
            {
                if(this.hasCapability(DinoCapability.IS_CARNIVORE) && item.hasCapability(DinoCapability.FEED_CARNIVORE))
                {
                    actions.add(new FeedAction(this, (PortableItem) item));
                }
                if (this.hasCapability(DinoCapability.IS_HERBIVORE) && item.hasCapability(DinoCapability.FEED_HERBIVORE))
                {
                    actions.add(new FeedAction(this, (PortableItem) item));
                }
            }

        }
        return actions;
    }

    /**
     * Figure out what to do next.
     * <p>
     * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     *
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {

        //check food level
        if(this.checkStatus(display,map)!=null){
            return new DieAction();
        }
        if(this.pregnant){ //pregnant female dinosaur
            incrementPregnantCounter();

            if(pregnantCounter>=10){

                new LayEggAction().execute(this, map);
                //reset pregnant
                setPregnantCounter(0);
                setPregnant(false);

            }
        }

        Action resBehaviour = null;
        for (int i = 0; i < behaviour.size() && (this.isConscious()); i++) { //get behaviours
            //if cannot find a breeding target do something else
            if(this.getFoodLevel()>=50 && behaviour.get(0).getAction(this, map)!=null){
                    //always get breeding behaviour if allowed
                    resBehaviour = behaviour.get(0).getAction(this, map);

            }
            else if (behaviour.get(i) instanceof BreedBehaviour){
                i++; //go to next behaviour
                //gives eat behaviour
                resBehaviour = behaviour.get(i).getAction(this, map);
            }

            else{
                //gives wander
                resBehaviour = behaviour.get(i).getAction(this, map);
            }

            if (resBehaviour != null) 
                return resBehaviour;
        }

        return new DoNothingAction();

    }

    /**
     * A public boolean getter that returns male
     * @return male
     */
    public boolean getMale(){
        return male;
    }

    /**
     * A protected void setter that sets a boolean of male
     */
    protected void setMale(boolean male){
        this.male = male;
    }

    /**
     * A protected void method that decrements a specific actor's food level
     */
    protected void decrementFoodLevel(){
        this.foodLevel--;
    }

    /**
     * A protected void method that decrements a specific actor's water level
     */
    protected void decrementWaterLevel(){
        this.waterLevel--;
    }



    /**
     * A public int getter that returns foodLevel
     * @return foodLevel
     */
    public int getFoodLevel(){
        return foodLevel;
    }

    /**
     * A public int getter that returns waterLevel
     * @return waterLevel
     */
    public int getWaterLevel(){
        return waterLevel;
    }

    /**
     * A public void method that sets a boolean to determine a specific actor's pregnancy
     */
    public void setPregnant(boolean b){
        this.pregnant = b;
    }

    /**
     * A public boolean getter that returns pregnant for a specific actor
     * @return pregnant
     */
    public boolean getPregnant(){
        return this.pregnant;
    }







    /**
     * A public void setter that sets foodLevel
     * @param foodLevel , a value to be set for foodLevel
     */
    public void setFoodLevel(int foodLevel){
        if(foodLevel>=100){
            this.foodLevel = 100;
        }
        else{
            this.foodLevel = foodLevel;
        }
    }

    /**
     * A public void getter that adds foodLevel
     * @param foodLevel , a value to be added on top of its foodLevel
     */
    public void addFood(int foodLevel) {
        if (this.foodLevel + foodLevel >= 100) {
            this.foodLevel = 100;
        } else {
            this.foodLevel += foodLevel;
        }
    }



    /**
     * A public void getter that adds waterLevel
     * @param waterLevel , a value to be added on top of its foodLevel
     */
    public void addWater(int waterLevel) {
        if (this.waterLevel + waterLevel >= 200) {
            this.waterLevel = 200;
        } else {
            this.waterLevel += waterLevel;
        }
    }

    /**
     * A private void method that increments a specific actor's pregnancy counter
     */
    private void incrementPregnantCounter(){
        this.pregnantCounter++;
    }

    /**
     * A protected void method that sets pregnant counter to a value determined from its parameter set
     * @param set , a value to be set for pregnantCounter
     */
    protected void setPregnantCounter(int set){
        this.pregnantCounter = set;
    }

    /**
     * A private int getter that gets a specific actor's unconsciousCounter
     * @return unconsciousCounter
     */
    private int getUnconsciousCounter(){
        return this.unconsciousCounter;
    }

    /**
     * A private void method that increments a specific actor's unconsciousCounter
     */
    private void incrementUnconsciousCounter(){
        this.unconsciousCounter++;
    }


    /**
     * checkStatus first checks its food level and it can decrement the values.
     * It gives an warning message for a conscious actor with less than 50 foodLevel
     * If the food level are less than 0 then it reduces the actor's health and
     * increment unconscious counter. If the counter is more than 20, it raises a DieAction.
     *
     * @param display , to display which actor is getting hungry with specified location.
     * @param map , a map that contains an actor
     * @return DieAction if the unconscious counter is more than 20. Otherwise, it returns null.
     */
    protected Action checkStatus(Display display, GameMap map){

        if(getFoodLevel()>0 && getWaterLevel()>0){
            decrementFoodLevel();
            decrementWaterLevel();
            if(getFoodLevel()<50 && this.isConscious()) {
                display.println(this + " at " + "[" + map.locationOf(this).x() + "]" + "[" + map.locationOf(this).y() + "]" + " is getting hungry");
            }
            if(getWaterLevel()<40 && this.isConscious()) {
                display.println(this + " at " + "[" + map.locationOf(this).x() + "]" + "[" + map.locationOf(this).y() + "]" + " is getting thirsty");
            }

        }


        else {
            if(hitPoints > 0){
                //auto sets to unconscious once gets to 0 hit points
                hurt(hitPoints); //set health to 0
            }
            incrementUnconsciousCounter();
            display.println(this + " at " + "[" + map.locationOf(this).x() + "]" + "[" + map.locationOf(this).y() + "]" + " is unconscious");
            if (Lake.rain){
                addWater(10);
            }
            if (getUnconsciousCounter() >= 15) {
                return new DieAction();
            }
        }
        return null;
    }

}