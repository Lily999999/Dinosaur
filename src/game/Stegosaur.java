package game;



/**
 * This is a public class Stegosaur, which is a child class of Dinosaur.
 */
public class Stegosaur extends Dinosaur {




	/** 
	 * public constructor.
	 * All Stegosaurs are represented by a 's' and have 100 hit points.
	 *
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name) {
		super(name, 's', 100);
		this.addCapability(DinoCapability.IS_HERBIVORE);
		this.addCapability(DinoCapability.DRINK_BY_SELF);

	}

	/**
	 * Overloaded constructor to specify gender
	 * @param name , a String, used to input the name of the Stegosaur instance
	 * @param male , specifies whether the dinosaur is a male or female
	 */
	public Stegosaur(String name, boolean male) {
		super(name, 's', 100);
		super.setMale(male);
		this.addCapability(DinoCapability.IS_HERBIVORE);
		this.addCapability(DinoCapability.DRINK_BY_SELF);
	}

}



