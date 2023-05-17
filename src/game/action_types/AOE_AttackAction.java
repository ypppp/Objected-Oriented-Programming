package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.RandomNumberGenerator;
import game.Species;
import game.Status;
import game.entity.enemies.Enemy;

import java.util.ArrayList;

/**
 * An Action to attack the surrounding area
 * @author Tong Jet Kit
 * @version 1.0
 * @see Action
 */
public class AOE_AttackAction extends Action {

    /**
     * An array of targets that the actor will attack
     */
    private ArrayList<Actor> targets = new ArrayList<>();

    /**
     * The weapon used to attack the surrounding area
     */
    private Weapon weapon;

    /**
     * Constructor where the targets are unknown to the actor
     * @param weapon A weapon data that represents the weapon used to attack the surrounding area
     */
    public AOE_AttackAction(Weapon weapon) {

        this.weapon = weapon;

    }

    /**
     * Constructor where the targets are known to the actor
     * @param targets An array of actors which represents the targets the actor will damage
     * @param weapon A weapon data that represents the weapon used to attack the surrounding area.
     */
    public AOE_AttackAction(ArrayList<Actor> targets, Weapon weapon){
        this.targets = targets;
        this.weapon = weapon;
    }

    /**
     * Perform the Action to do an aoe attack.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        //if the aoe attack is from the player
        if(this.targets.size()==0){
            this.targets = AOE_AttackAction.getAllTargets(actor,map);
        }

        for(Actor target: targets){
//            if (!(RandomNumberGenerator.getRandomInt(100) <= weapon.chanceToHit())) {
//                result += actor + " misses " + target + ".\n" ;
//            }
//            else{
//                int damage = weapon.damage();
//                result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
//                target.hurt(damage);
//                if (!target.isConscious() && target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
//                    result += new DeathAction(actor).execute(target, map)+ "\n";
//                }
//            }
            result += new AttackAction(target,"around",weapon).execute(actor,map) + "\n";
        }
        return result;

    }

    /**
     * To obtain all the targets that the actor can attack
     * For enemies: Players and other Enemies of different types
     * For players: Enemies
     * @param actor The actor that is performing the action
     * @param map The map of the game
     * @return An arraylist of actor which contains the targets that the enemy can attack
     */
    public static ArrayList<Actor> getAllTargets(Actor actor,GameMap map){
        ArrayList<Actor> targets = new ArrayList<>();
        Location here = map.locationOf(actor);
        for(Exit exits: here.getExits()) {
            Location destination = exits.getDestination();
            if (destination.containsAnActor()) {
                Actor destinationActor = destination.getActor();
                //if the actor is a player
                if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    //if the target is an enemy
                    if (destinationActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                        targets.add(destinationActor);
                    }
                }
                // else if the actor is an enemy
                else if (actor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                    // if the other target is a player
                    if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        targets.add(destinationActor);
                    }
                    // else if the other target is an enemy of different type
                    else if (destinationActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                        if (!actor.findCapabilitiesByType(Species.class).equals(destinationActor.findCapabilitiesByType(Species.class))) {
                            targets.add(destinationActor);
                        }
                    }
                }
            }

        }
        return targets;

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks the surrounding area with " + weapon;
    }
}
