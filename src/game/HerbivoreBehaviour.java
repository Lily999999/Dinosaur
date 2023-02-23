package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

/**
 * HerbivoreBehaviour implements Behaviour interface and hence needs to implement its getAction method
 * Used to allow actors, specific to herbivores to have its own unique actions
 */
public class HerbivoreBehaviour implements Behaviour {

    /**
     * Get the suitable action based on the environment the actor is in.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return If an item has a capability of being fed by herbivore, we move the actor to the item and eat the item by returning EatBySelfAction
     * If a ground has a capability of being fed by herbivore, we move the actor to the item and eat the item by returning DRINKBYSELF
     *  
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {


        List<Exit> exits = map.locationOf(actor).getExits();


        for(Exit exit : exits)
        {
            //get items on the exit
            List<Item> items = exit.getDestination().getItems();
            //get exit's ground type
            Ground groundType = exit.getDestination().getGround();

            for (Item item: items)
            { //only follows if the food is 1 block away
                if(item.hasCapability(DinoCapability.EAT_BY_SELF_HERBIVORE) && !exit.getDestination().containsAnActor())
                {
                    map.moveActor(actor, exit.getDestination());

                    return new EatItemAction(item);

                }

            }
            if(groundType.hasCapability(DinoCapability.DRINK_BY_SELF) && !exit.getDestination().containsAnActor()){

                return new DrinkAction(groundType);




            }





        }
        return null;

    }



}
