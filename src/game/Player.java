package game;

import edu.monash.fit2099.engine.*;



/**
 * Class representing the Player.
 */
public class Player extends Actor {

	/**
	 * private attribute integer eco
	 */
	public int eco = 0;



	/**
	 * private attribute boolean male that randomises the chance of being male or female
	 */
	private boolean male = (Math.random() < 0.5);

	/**
	 * private attribute boolean pregnant
	 */
	private boolean pregnant = false;

	/**
	 * private attribute integer foodLevel
	 */
	private int foodLevel = 50;

	/**
	 * private attribute integer waterLevel
	 */
	private int waterLevel = 60;

	/**
	 * private call of Menu Class
	 */
	private Menu menu = new Menu();







	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}


	/**
	 * Select and return an action to perform on the current turn.
	 * If the player is at the top north of the original map, it will allow an actor to teleport to the second map.
	 * Also, if the player is at the bottom south of the original map, it will allow an actor to move back to the original map.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {


		//PickFruit
		if(map.locationOf(this).getGround() instanceof Tree){
			actions.add(new PickFruitAction(map.locationOf(this)));
		}
		//Ability to quit
		actions.add(new QuitAction());
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		display.println(this + " has "+getEco() + " eco points");
		return menu.showMenu(this, actions, display);

	}

	/**
	 * public void method addEco
	 * @param eco
	 * @type int
	 * @return added eco points
	 */
	public void addEco(int eco) {
		this.eco += eco;
	}

	/**
	 * public int method getEco is a getter
	 * @return eco
	 */
	public int getEco() {
		return this.eco;
	}

	/**
	 * a setter for pregnant
	 * @return pregnant in boolean
	 */
	@Override
	public void setPregnant(boolean bool) {
		this.pregnant = bool;
	}

	/**
	 * a getter for male
	 * @return male
	 */
	@Override
	public boolean getMale() {
		return this.male;
	}

	/**
	 * a getter for pregnant
	 * @return pregnant
	 */
	@Override
	public boolean getPregnant() {
		return this.pregnant;
	}

	/**
	 * a getter for FoodLevel in integer type
	 * @return foodLevel
	 */
	@Override
	public int getFoodLevel() {
		return this.foodLevel;
	}

	@Override
	public int getWaterLevel() {
		return this.waterLevel;
	}

	/**
	 * a setter for FoodLevel in integer type
	 * @param foodLevel
	 * @type int
	 * @return foodLevel
	 */
	@Override
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	/**
	 * a public void method that adds on to the food level
	 * @param foodLevel
	 * @type int
	 * @return foodLevel
	 */
	@Override
	public void addFood(int foodLevel) {
		if (foodLevel>=100){
			this.foodLevel = 100;
		}
		else{
			this.foodLevel = foodLevel;
		}
	}

	@Override
	public void addWater(int waterLevel) {
		this.waterLevel = waterLevel;

	}

}
