package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;


/**
 * Class which let Player go to the second map and go back the first map.
 */
public class Passage extends Item{


    public Passage() {
        super("passage", '✈', false);
    }



    /**
     * Add the action when the player is standing on the item
     * @param action
     */
    public void addAction(Action action) {
        this.allowableActions.add(action);
    }

    @Override
    public int foodToConsume() {
        return 0;
    }
}
