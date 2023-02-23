package edu.monash.fit2099.demo.mars;

import java.util.*;

import game.Behaviour;
import edu.monash.fit2099.engine.*;


public class Bug extends Actor {

	private Random rand = new Random();
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();

	public Bug() {
		super("Feature", 'x', 1);
	}
	
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		for (Behaviour factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return actions.get(rand.nextInt(actions.size()));
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions list = super.getAllowableActions(otherActor, direction, map);
		list.add(new KickAction(this));
		return list;
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(1, "stings");
	}

	@Override
	public void setPregnant(boolean bool) {

	}

	@Override
	public boolean getPregnant() {
		return false;
	}

	@Override
	public boolean getMale() {
		return false;
	}

	@Override
	public int getFoodLevel() {
		return 0;
	}

	@Override
	public int getWaterLevel() {
		return 0;
	}

	@Override
	public void setFoodLevel(int food) {

	}

	@Override
	public void addFood(int food) {

	}

	@Override
	public void addWater(int waterLevel) {

	}
}
