package game;

/**
 * StegosaurEgg is a type of egg that hatches into BabyStegosaur.
 * This is a child class of Egg.
 */
public class StegosaurEgg extends Egg{

    /**
     * private constant and static attribute integer HATCH_ECO that gives eco to a player once hatched
     */
    private static final int HATCH_ECO = 100;

    /**
     * private constant and static attribute integer COST that determines a cose of the egg
     */
    private static final int COST = 200;

    /**
     * constant private static integer ADD_FOOD of 10, specifies how much food should be added to an actor upon consumption
     */
    private static final int ADD_FOOD = 10;




    /**
     * Public Constructor to instantiate objects of this class and add capability EAT_BY_SELF_CARNIVORE
     */
    public StegosaurEgg(){
        super("Stegosaur Egg",'♥');
        this.addCapability(DinoCapability.EAT_BY_SELF_CARNIVORE);
        this.addCapability(DinoCapability.FEED_CARNIVORE);
    }

    /**
     * Public int getter for hatchEco that returns Eco points once hatched
     * @return HATCH_ECO
     */
    @Override
    public int getAddEco(){
        return HATCH_ECO;
    }

    /**
     * Public int getter for cost that returns cost of the egg
     * @return COST
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * A public int getter for getFood that returns addFood
     * @return ADD_FOOD
     */
    @Override
    public int foodToConsume(){
        return ADD_FOOD;
    }



}

