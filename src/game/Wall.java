package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * public class wall extends from ground. This is a type of ground that a player cannot enter
 */
public class Wall extends Ground {

	/**
	 * private constant and static integer ADD_FOOD that specifies how much food an actor should get if it were to eat a wall
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * A constant private static integer ADD_WATER of 0, specifies how much water level should be added to an actor upon consumption
	 */
	private static final int ADD_WATER = 0;

	/**
	 * Public constructor that creates a ground type by passing a display character to the parent constructor
	 */
	public Wall() {
		super('#');
	}
	

	/**
	 * public overridden method to not allow the player to enter this ground type
	 * @return false: boolean
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	

	/**
	 * Public method overridden from its super class
	 * @see Ground#blocksThrownObjects()
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}


	/**
	 * A public getter to get ADD_FOOD attribute
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
