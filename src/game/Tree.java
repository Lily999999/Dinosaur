package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
/**
 * A public class Tree extended from Ground.
 * This class allows to control the maturity of tree and chance of dropping action.
 */
public class Tree extends Ground {
	/**
	 * private attribute integer that is the age of the tree
	 */
	private int age = 0;

	/**
	 * private attribute integer that determines a chance of dropping a fruit from a tree
	 */
	private static final int CHANCE_TO_DROP_FRUIT = 50;

	/**
	 * private attribute final integer used to specify the value to be added to an actor's food level if eaten
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * A constant private static integer ADD_WATER of 0, specifies how much water level should be added to an actor upon consumption
	 */
	private static final int ADD_WATER = 0;

	/**
	 * public Constructor to instantiate objects of this class
	 */
	public Tree() {
		super('+');
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

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';


		double random = Math.random()*100;


		
		//giving chance to drop a Fruit on each turn
		if(random<=CHANCE_TO_DROP_FRUIT)
		{
			Fruit fruit = new Fruit();
			location.addItem(fruit);
		
		}


		
	}


	/**
	 * public overridden method to not allow the player to enter this ground type
	 * @return false: boolean
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor instanceof Pterodactyls || actor instanceof BabyPterodactyls ) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * a getter for addFood
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
