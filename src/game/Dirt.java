package game;

import edu.monash.fit2099.engine.*;

/**
 * A class that represents dirt.
 */
public class Dirt extends Ground {

	/**
	 * private static and constant attribute of type integer. The amount of food to add if an instance of this class were to be eaten by an actor
	 */
	private static final int ADD_FOOD = 0;

	/**
	 * constant private static integer ADD_WATER of 0, specifies how much water level should be added to an actor upon consumption
	 */
	private static final int ADD_WATER = 0;

	/**
	 * public empty Constructor, it instantiate the display character of the dirt
	 */
	public Dirt() {
		super('.');
	}

	/**
	 * This is a public void method that loops through the exits in its locations to generate bush if the ground type nearby allows it to
	 * @param location : The location of the Ground
	 */
	@Override
	public void tick(Location location) {
					int bushCounter = 0;
					double random = Math.random()*99+1;
					int chanceToGrowNextToTree = 2;
					int chanceToGrowNextToBush = 10;
					boolean bushGrew = false;
					
					for (Exit exit : location.getExits()) {
						Location destination = exit.getDestination();

						if(destination.getGround() instanceof Bush) {
							bushCounter++;

							if(bushCounter>=2 && random<=chanceToGrowNextToBush) {

								Ground bush = new Bush();
								location.setGround(bush);
								bushGrew = true;

							}

						}
						else if((destination.getGround() instanceof Tree)&&(random<=chanceToGrowNextToTree)) {
							Ground bush = new Bush();
					location.setGround(bush);
					bushGrew = true;
					
			}

						//adding eco points to the player
						for (int i = 0; i < location.map().getXRange().max() && bushGrew; i++)
						{
							for (int j = 0; j < location.map().getYRange().max(); j++)
							{
								GameMap map = location.map();
								Actor actor = map.at(i,j).getActor();

								if(actor instanceof Player)
								{
									((Player) actor).addEco(1);
								}
							}
						}

		}
		
	}

	/**
	 * A public getter method
	 * @return ADD_FOOD
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

