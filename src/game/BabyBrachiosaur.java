package game;

/**
 * A baby dinosaur that will grow into an Brachiosaur. A subclass of BabyDinosaur.
 */
public class BabyBrachiosaur extends BabyDinosaur {

    /**
     * Empty Constructor used to create instances of this class.
     * Provides hard coded values to super constructor to ensure the same name
     * and display character for all the instances of this class.
     */
    public BabyBrachiosaur() {
        super("BabyBrachiosaur", 'Σ');
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);
    }

}
