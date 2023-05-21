package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.Species;
import game.Status;
import game.action_types.AttackAction;
import game.action_types.LifestealAction;

import java.util.ArrayList;

/**
 * The behaviour of the enemy to do a lifesteal attack action on a player or enemy of different type where the  is prioritised first
 * @author Tong Jet Kit
 * @see Behaviour
 * @version 1.0
 */
public class LifestealBehaviour implements Behaviour{
    /**
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return A lifesteal Action if the actor can perform it
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        ArrayList<Action> actions = new ArrayList<>();

        if(RandomNumberGenerator.getRandomInt(100)<40){
            Location here = map.locationOf(actor);
            for(Exit exits: here.getExits()){
                if(exits.getDestination().containsAnActor()){
                    Actor surroundingActor = exits.getDestination().getActor();
                    // if the actor around it is a player/ally (PRIORITIZED)
                    if(surroundingActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                        if(actor.getWeaponInventory().size() == 0){
                            return new LifestealAction(surroundingActor, exits.getName());
                        }
                        else{
                            return new LifestealAction(surroundingActor, exits.getName(),surroundingActor.getWeaponInventory().get(0));
                        }

                    }
                    // else if its an enemy then it checks if its a different type
                    else if (surroundingActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                        if(!actor.findCapabilitiesByType(Species.class).equals(surroundingActor.findCapabilitiesByType(Species.class))){
                            if(actor.getWeaponInventory().size() == 0){
                                actions.add( new LifestealAction(surroundingActor, exits.getName()));
                            }
                            else{
                                actions.add(new LifestealAction(surroundingActor, exits.getName(),surroundingActor.getWeaponInventory().get(0)));
                            }
                        }

                    }
                }

            }
        }
        if(!actions.isEmpty()){
            return actions.get(RandomNumberGenerator.getRandomInt(actions.size()));
        }
        else{
            return null;
        }
    }

}
