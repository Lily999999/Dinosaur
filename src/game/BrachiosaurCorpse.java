package game;

/**
 * A subclass of Corpse, used to spawn corpses of Brachiosaur dinosaur types.
 */
public class BrachiosaurCorpse extends DinosaurCorpse{

    /**
     * private static constant integer attribute to specify how many food points and actor should gain when the item is eaten
     * overrides that of the corpse class
     */
    private final static int ADD_FOOD = 100;


    /**
     * Empty Constructor to instantiate objects of this class
     */
    public BrachiosaurCorpse() {
        super("Brachiosaur Corpse", 'β');
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
