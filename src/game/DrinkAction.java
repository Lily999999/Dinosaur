package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Ground;

/**
 * Extended from Action Class, this class implements drinking water
 */
public class DrinkAction extends Action {

    /**
     * private attribute of type Item. The item to be eaten
     */
    private Ground ground;

    /**
     * A public Constructor which instantiate the object of this class
     * @param ground
     */
    public DrinkAction(Ground ground){
        this.ground = ground;
    }

    /**
     * A public method which increases the water level, removes water after being drunk, and add water to the actor.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        map.locationOf(actor);

        Lake.water --;
        actor.addWater(ground.drink());
        return actor +" at [" + map.locationOf(actor).x() + "]["+map.locationOf(actor).y() +"] drinks 1 sip of water" + " and gains " + (ground.drink() + " to its water level");
    }

    /**
     * Description of the water level added and the water
     * @param actor The actor performing the action.
     * @return String
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks 1 sip of water " + ground + " and gains " + (ground.drink() + " to its water level");
    }
}