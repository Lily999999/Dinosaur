package game;

public class PterodactylsEgg extends Egg {

    /**
     * A private constant and static attribute of HATCH_ECO, used to get the amount of eco a player should get when the egg hatches.
     */
    private static final int HATCH_ECO = 300;

    /**
     * private constant and static integer attribute to provide the COST of the egg when purchasing from the vending machine
     */
    private static final int COST = 1000;


    /**
     * Empty Constructor, passes hard-coded values into the super constructor to ensure
     * all instances of this class have the same name and display character.
     * Also, it ensures that all instances of this class have the same DinoCapability so that it can be
     * eaten by Allosaurs dinosaur type.
     */
    public PterodactylsEgg() {
        super("Pterodactyls Egg", '$');


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
}
