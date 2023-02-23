package game;


/**
 * Pterodactyls is a subclass of Dinosaur. This dinosaur is a CARNIVORE
 */
public class Pterodactyls extends Dinosaur {

    /**
     * Constructor
     * @param name , a String, used to input the name of the Pterodactyls instance
     */
    public Pterodactyls(String name) {
        super(name, 'p', 5);
        this.addCapability(DinoCapability.IS_CARNIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);
        this.addCapability(DinoCapability.EAT_FISH);

    }

    /**
     * Overloaded constructor to specify gender
     * @param name , a String, used to input the name of the Brachiosaur instance
     * @param male , specifies whether the dinosaur is a male or female
     */
    public Pterodactyls(String name, boolean male) {
        super(name, 'p', 5);
        super.setMale(male);
        this.addCapability(DinoCapability.IS_CARNIVORE);
        this.addCapability(DinoCapability.DRINK_BY_SELF);
        this.addCapability(DinoCapability.EAT_FISH);

    }


}