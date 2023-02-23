package edu.monash.fit2099.interfaces;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.
 */

public interface ActorInterface {
    public  void setPregnant(boolean bool);
    public boolean getPregnant();
    public boolean getMale();
    public int getFoodLevel();
    public int getWaterLevel();
    public void setFoodLevel(int foodLevel);
    public void addFood(int foodLevel);
    public void addWater(int waterLevel);

}
