package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * This is a public class that extends Action. This is to quit the game.
 */
public class QuitAction extends Action{

    @Override
    /**
     * This method is to throw a RuntimeError
     * @param actor , the actor that needs to die
     * @param map , the map the actor is on
     */
    public String execute(Actor actor, GameMap map)  {
        System.out.println("Game End");
        System.exit(0);
        return "0";

    }

    @Override
    /**
     * descriptive description in the menu
     * @param actor , actor that could perform this action
     * @return string, a descriptive string to describe the option
     */
    public String menuDescription(Actor actor) {
        return "Quit";
    }


    
}
