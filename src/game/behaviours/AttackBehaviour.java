package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.action_types.AttackAction;
import game.entity.enemies.Enemy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class AttackBehaviour implements Behaviour {



    @Override
    public Action getAction(Actor actor, GameMap map) {
        HashMap<Integer, Actor> attackableList = new HashMap<Integer, Actor>();
        HashMap<Integer, Exit> enemyCoordinates = new HashMap<Integer, Exit>();


        int counter = 2;
        Location currentLoc = map.locationOf(actor);
        for(Exit exits: currentLoc.getExits()) {
            Location destination = exits.getDestination();
            if (destination.containsAnActor()) {
                Actor destinationActor = destination.getActor();
                if (destinationActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                    attackableList.put(counter,destinationActor);
                    enemyCoordinates.put(counter,exits);
                    counter += 1;}
                else if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    attackableList.put(1,destinationActor);
                    enemyCoordinates.put(1,exits);
                }
            }

        }
        if (actor.hasCapability(Status.HAS_SKILL)){
            if (RandomNumberGenerator.getRandomInt(100) < 50){
                Collection<Actor> values = attackableList.values();
                ArrayList<Actor> actorlists = new ArrayList<>(values);
                return ((Enemy) actor).getSkill(actorlists);

            }


        }
        else{
            return new AttackAction(attackableList.get(1),enemyCoordinates.get(1).getName());
        }




        return null;

    }

}
