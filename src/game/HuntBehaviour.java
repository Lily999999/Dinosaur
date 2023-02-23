package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class HuntBehaviour implements Behaviour {


    /**
     * Allow for allosaurs to attack an specific target, which is found by using exits.
     * @param actor , the actor who is having this behaviour
     * @param map , the map the actor is on
     * @return AttackAction if suitable target is found and is nearby or return null.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        
        List<Exit> exits = map.locationOf(actor).getExits();

        for (Exit exit : exits) {
            // get items on the exit
            List<Item> items = exit.getDestination().getItems();

            if (exit.getDestination().containsAnActor()) { // Only attacking stegosaur type dinosaurs
                Actor target = exit.getDestination().getActor();
                if ( actor instanceof Allosaur && (target instanceof Stegosaur || target instanceof BabyStegosaur || target instanceof Pterodactyls || target instanceof BabyPterodactyls))
                 {
                    return new AttackAction(target);
                 }

            }


        }
        return null;
    }

    
}
