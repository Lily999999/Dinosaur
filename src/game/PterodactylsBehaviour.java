package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class PterodactylsBehaviour implements Behaviour {

    /**
     * Get the suitable action based on the environment the actor is in.
     *
     * @param actor , the actor who is having this behaviour
     * @param map   , the map the actor is on
     * @return AttckAction if one or more of the exits contains a DinosaurCorpse or EatBySelfAction
     * if one or more of the exits contains an item that has a capability DinoCapability.EAT_BY_SELF_CARNIVORE
     * and doesn't contain another actor or null if there are no actors to attack or items to eat nearby
     * If a ground has a capability of being fed by herbivore, we move the actor to the item and eat the item by returning DRINKBYSELF
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        List<Exit> exits = map.locationOf(actor).getExits();


        for (Exit exit : exits) {
            //get items on the exit
            List<Item> items = exit.getDestination().getItems();
            //get exit's ground type
            Ground groundType = exit.getDestination().getGround();


            //Goes here if no target nearby
            for (Item item : items) { //! only follows if the food is close by (1 block away)
                //cannot eat their own eggs

                if (item.hasCapability(DinoCapability.EAT_BY_SELF_CARNIVORE) && !exit.getDestination().containsAnActor()
                        //doesn't contain any name of its own type
                        && !(item.getClass().getName().substring(5).contains(actor.getClass().getName().substring(5)))) {

                    map.moveActor(actor, exit.getDestination()); //move to the item
                    return new EatItemAction(item); //eat the item
                }

                if (groundType.hasCapability(DinoCapability.DRINK_BY_SELF) && !exit.getDestination().containsAnActor()) {

                    return new DrinkAction(groundType);




                    }
                if (groundType.hasCapability(DinoCapability.EAT_BY_PTERODACTYLS) && !exit.getDestination().containsAnActor()) {
                    map.moveActor(actor, exit.getDestination());
                    return new EatGroundAction(groundType);
                }

            }


        }
        return null;
    }
}