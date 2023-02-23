package game;

/**
 * Brachiosaur is a subclass of Dinosaur. This dinosaur is a Herbivore
 */
public class Brachiosaur extends Dinosaur {

    /**
     * Constructor
     * @param name , a String, used to input the name of the Brachiosaur instance
     */
    public Brachiosaur(String name) {
        super(name, 'b', 100);
        super.setFoodLevel(100);
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);

    }

    /**
     * Overloaded constructor to specify gender
     * @param name , a String, used to input the name of the Brachiosaur instance
     * @param male , specifies whether the dinosaur is a male or female
     */
    public Brachiosaur(String name, boolean male) {
        super(name, 'b', 100);
        super.setFoodLevel(100);
        super.setMale(male);
        this.addCapability(DinoCapability.IS_HERBIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);

    }


}
