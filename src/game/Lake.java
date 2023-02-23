package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import java.util.Random;

public class Lake extends Ground {
    /**
     * Private attribute integer that determines a chance of
     * dropping a fruit from a tree
     */
    private static final int CHANCE_TO_ADD_FISH = 60;

    /**
     * A constant private final integer addFood of 0, shows how much food level actor should get upon consumption of this class instance
     */
    private static final int ADD_FOOD = 5;

    /**
     * A constant private static integer ADD_FOOD of 30, specifies how much water level should be added to an actor upon consumption
     */
    private static final int ADD_WATER = 30;

    /**
     * Private attribute integer that determines a chance of raining
     */
    private static final int CHANCE_TO_RAIN = 2;

    public static boolean rain;

    public static int fish =5;

    public static int water =25;

    /**
     * A public constructor that determines displayChar
     */
    public Lake() {
        super('~');


    }

    /**
     * Control the chance of adding a fish
     * overriding public method tick.
     *
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        this.addCapability(DinoCapability.DRINK_BY_SELF);
        this.addCapability(DinoCapability.EAT_BY_PTERODACTYLS);

        double r1 = Math.random() * 100;
        double r2 = Math.random() * 100;




        //chance to generate a fish on each turn

        while (fish < 25) {


            if (r1 <= CHANCE_TO_ADD_FISH) {
                fish++;

            }
        }




        if (r2 <= CHANCE_TO_RAIN) {
            boolean rain = true;
            Random r = new Random();
            int ranrain = (r.nextInt(6)+1);

            switch(ranrain){
                case 1:
                     water += 2;
                    break;
                case 2:
                    water += 4;
                    break;
                case 3:
                    water += 6;
                    break;
                case 4:
                    water += 8;
                    break;
                case 5:
                    water += 10;
                    break;
                case 6:
                    water += 12;
                    break;
                default:
                    System.out.println("Something is wrong");
                    break;


            }

        }




    }

    /**
     * public overridden method to not allow the player to enter this ground type
     * @return false: boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor instanceof Pterodactyls || actor instanceof BabyPterodactyls ) {
            return true;
        }
        else {
            return false;
        }
    }






    /**
     * A getter int foodToConsume that returns addFood
     * @return addFood
     */
    @Override
    public int foodToConsume() {
        return ADD_FOOD;
    }


    /**
     * a getter for ADD_WATER
     * @return ADD_WATER
     */
    @Override
    public int drink(){
        return ADD_WATER;
    }
}
