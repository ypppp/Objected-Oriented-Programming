package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
import game.Status;
import game.action_types.AttackAction;
import game.entity.enemies.Enemy;

import java.util.*;


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
                    if(destinationActor.getDisplayChar()!= actor.getDisplayChar()){
                        attackableList.put(counter,destinationActor);
                        enemyCoordinates.put(counter,exits);
                        counter++;
                    }

                }
                else if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    attackableList.put(1,destinationActor);
                    enemyCoordinates.put(1,exits);
                }

            }

        }

        if(!attackableList.isEmpty()){

            if (actor.hasCapability(Status.HAS_SKILL) && RandomNumberGenerator.getRandomInt(100) < 50){

                Collection<Actor> values = attackableList.values();
                ArrayList<Actor> actorlists = new ArrayList<>(values);
                return ((Enemy) actor).getSkill(actorlists);
            }
            else{

                Map.Entry<Integer,Actor> attackableIterator = attackableList.entrySet().iterator().next();
                Map.Entry<Integer,Exit> coordinateIterator = enemyCoordinates.entrySet().iterator().next();
                if(actor.getWeaponInventory().size()!=0){
                    WeaponItem attackWeapon = actor.getWeaponInventory().get(0);
                    if(attackWeapon.hasCapability(Status.HAS_AOE_ATTACK_SKILL)){
                        return attackWeapon.getSkill(actor);
                    }
                    else{
                        return new AttackAction(attackableIterator.getValue(),coordinateIterator.getValue().getName(),attackWeapon);
                    }
                }
                else {
                    return new AttackAction(attackableIterator.getValue(),coordinateIterator.getValue().getName());
                }



            }

        }


        return null;

    }

}
