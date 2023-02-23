package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;


/**
 * LayEggAction is an action performed when an actor is ready to lay an egg
 */
public class LayEggAction extends Action{

    

	/**
	 * Used to execute the action. Provides all the behaviours that should happen once this behaviour is executed
	 * @param actor , which actor is performing this action.
	 * @param map , the map instance on which the actor exists.
	 * @see Action#execute(Actor, GameMap)
	 */
	@Override
	public String execute(Actor actor, GameMap map) {

        if(actor instanceof Stegosaur){
            map.locationOf(actor).addItem(new StegosaurEgg());
        }   
        else if (actor instanceof Allosaur){
            map.locationOf(actor).addItem(new AllosaurEgg());
		}
		else if (actor instanceof Brachiosaur){
            map.locationOf(actor).addItem(new BrachiosaurEgg());
		}
		else if (actor instanceof Pterodactyls){
			map.locationOf(actor).addItem(new PterodactylsEgg());
		}

        return actor + " at [" + map.locationOf(actor).x()+"]["+map.locationOf(actor).y()+"] lays an egg";
	}


	/**
	 * Menu description is a method  that displays a message on the menu when the action is able to be performed
	 * @param actor , the actor that is performing this action
	 * @see Action#menuDescription(Actor)
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " lays an egg";
	}
    
}
