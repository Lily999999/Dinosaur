package game;

public class BabyPterodactyls extends BabyDinosaur{
    /**
     * Empty Constructor used to create instances of this class.
     * Provides hard coded values to super constructor to ensure the same name
     * and display character for all the instances of this class.
     */
    public BabyPterodactyls(){
        super("BabyPterodactyls",'%');
        super.setFoodLevel(20);
        this.addCapability(DinoCapability.IS_CARNIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);
    }
}
