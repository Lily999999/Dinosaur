package game;


import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A public class Bush that is extended from Ground
 */
public class Bush extends Ground {

	/**
	 * private attribute integer that determines a chance of
	 * dropping a fruit from a tree
	 */
	private static final int CHANCE_TO_DROP_FRUIT = 10;

	/**
	 * A constant private final integer addFood of 0, shows how much food level actor should get upon consumption of this class instance
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * A constant private static integer ADD_WATER of 0, specifies how much water level should be added to an actor upon consumption
	 */
	private static final int ADD_WATER = 0;

	/**
	 * A public constructor that determines displayChar
	 *
	 */
	public Bush() {
		super('^');

	}

	/**
	 * Control the chance of dropping a fruit
	 * overriding public method tick.
	 * @param location The location of the Ground
	 *
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);

		double random = Math.random()*100;



		//giving chance to drop a Fruit on each turn
		if(random<=CHANCE_TO_DROP_FRUIT)
		{
			Fruit fruit = new Fruit();
			location.addItem(fruit);

		}

	}
	/**
	 * A getter int foodToConsume that returns addFood
	 * @return addFood
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
