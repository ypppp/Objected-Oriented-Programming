package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.Status;
import game.action_types.AttackAction;
import game.action_types.LifestealAction;

public class LifestealBehaviour implements Behaviour{
    /**
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(RandomNumberGenerator.getRandomInt(100)<40){
            Location here = map.locationOf(actor);
            for(Exit exits: here.getExits()){
                if(exits.getDestination().containsAnActor()){
                    Actor surroundingActor = exits.getDestination().getActor();
                    if(surroundingActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                        if(actor.getWeaponInventory().size() == 0){
                            return new LifestealAction(surroundingActor, exits.getName());
                        }
                        else{
                            return new LifestealAction(surroundingActor, exits.getName(),surroundingActor.getWeaponInventory().get(0));
                        }

                    }
                }

            }
        }
        return null;
    }

}
