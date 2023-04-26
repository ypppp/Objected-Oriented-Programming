package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.RandomNumberGenerator;
import game.Status;
import game.entity.enemies.Enemy;

import java.util.ArrayList;

public class AOE_AttackAction extends Action {


    private ArrayList<Actor> targets = new ArrayList<>();

    private Weapon weapon;


    public AOE_AttackAction(Weapon weapon) {

        this.weapon = weapon;

    }

    public AOE_AttackAction(ArrayList<Actor> targets, Weapon weapon){
        this.targets = targets;
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        //if the aoe attack is from the player
        if(this.targets.size()==0){
            this.targets = getAllTargets(actor,map);
        }

        for(Actor target: targets){
            if (!(RandomNumberGenerator.getRandomInt(100) <= weapon.chanceToHit())) {
                result += actor + " misses " + target + "." ;
            }
            else{
                int damage = weapon.damage();
                result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
                target.hurt(damage);
                if (!target.isConscious()) {
                    result += new DeathAction(actor).execute(target, map) + "\n";
                }
            }
        }
        return result;

    }

    public ArrayList<Actor> getAllTargets(Actor actor,GameMap map){
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
                        if (destinationActor.getDisplayChar()!= actor.getDisplayChar()) {
                            targets.add(destinationActor);
                        }
                    }
                }
            }

        }
        return targets;

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks the surrounding area with " + weapon + " for" + weapon.damage();
    }
}
