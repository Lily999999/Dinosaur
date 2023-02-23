package game;



/**
 * This is a public class PterodactylsCorpse that is a child of DinosaurCorpse class
 * It gives addFood of 30 once eaten.
 */
public class PterodactylsCorpse extends DinosaurCorpse {

    /**
     * private static and constant integer attribute to specify how many food points and actor should gain when the item is eaten
     * overrides that of the corpse class
     */
    private final static int ADD_FOOD = 30;




    /**
     * A public constructor that instantiate objects of this class.
     */
    public PterodactylsCorpse() {
        super("Pterodactyls Corpse", 'π');
    }

    /**
     * a public method to get the hatchEco of this instance. Classes outside of this package do no need to use this method
     * @return integer, this instance's HATCH_ECO
     */
    @Override
    public int getAddEco() {
        return ADD_ECO;
    }

    /**
     * A public int getter for getFood that returns addFood
     * @return ADD_FOOD
     */
    @Override
    public int foodToConsume() {
        return ADD_FOOD;
    }




}