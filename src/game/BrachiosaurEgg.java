package game;

/**
 * BrachiosaurEgg is a type of egg that hatches into Baby Brachiosaurs.
 * Subclass of Egg, can eaten by carnivores.
 */
public class BrachiosaurEgg extends Egg {

    /**
     * A private constant and static attribute of HATCH_ECO, used to get the amount of eco a player should get when the egg hatches.
     */
    private static final int HATCH_ECO = 300;

    /**
     * private constant and static integer attribute to provide the COST of the egg when purchasing from the vending machine
     */
    private static final int COST = 500;

    /**
     * A constant private static integer ADD_FOOD of 10, specifies how much food should be added to an actor upon consumption
     */
    private static final int ADD_FOOD = 10;



    /**
     * Empty Constructor, passes hard-coded values into the super constructor to ensure
     * all instances of this class have the same name and display character.
     * Also, it ensures that all instances of this class have the same DinoCapability so that it can be
     * eaten by Allosaurs dinosaur type.
     */
    public BrachiosaurEgg() {
        super("Brachiosaur Egg", '♡');
        this.addCapability(DinoCapability.EAT_BY_SELF_CARNIVORE);
        this.addCapability(DinoCapability.FEED_CARNIVORE);

    }


    /**
     * a public method to get the hatchEco of this instance. Classes outside of this package do no need to use this method
     * @return integer, this instance's HATCH_ECO
     */
    @Override
    public int getAddEco() {
        return HATCH_ECO;
    }


    /**
     * a public method from purchasable interface. Used as a getter to get the privat attribute cost of this instance
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
