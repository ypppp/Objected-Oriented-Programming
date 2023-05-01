package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.RandomNumberGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickStepAction extends Action {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;


    /**
     * Weapon used for the attack
     */
    private Weapon weapon;


    public QuickStepAction(Actor target, String direction, Weapon weapon) {
       this.target = target;
       this.direction = direction;
       this.weapon = weapon;
    }


    /**
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        if (!(RandomNumberGenerator.getRandomInt(100) < weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }




        int damage =  weapon.damage();
        result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage."+"\n";
        target.hurt(damage);

        Location currentLocation = map.locationOf(actor);
        ArrayList<Exit> moveExits = new ArrayList<>();

        // get all location with no actors

        for(Exit exits: currentLocation.getExits()){
            if(exits.getDestination().canActorEnter(actor)){
                moveExits.add(exits);
            }
        }

        if(!moveExits.isEmpty()){
            Exit exitToMove = moveExits.get(RandomNumberGenerator.getRandomInt(moveExits.size()));
            result += new MoveActorAction(exitToMove.getDestination(),exitToMove.getName()).execute(actor,map);
        }
        else{
            result += actor + " can't move ";
        }

        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }

        return result;
    }

    /**
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " quick step and attacks " + target + " at " + direction + " with " + weapon;
    }
}