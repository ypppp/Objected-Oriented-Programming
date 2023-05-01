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

    private final Random random = new Random();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor destinationActor = destination.getActor();
                if (destinationActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                    if(destinationActor.getDisplayChar()!= actor.getDisplayChar()){
                        if(actor.getWeaponInventory().size()!=0){
                            WeaponItem weapon = actor.getWeaponInventory().get(0);
                            if(weapon.hasCapability(Status.HAS_AOE_ATTACK_SKILL)){
                                actions.add(weapon.getSkill(actor));
                            }
                            else{
                                actions.add(new AttackAction(destinationActor,exit.getName(),weapon));
                            }
                        }
                        actions.add(new AttackAction(destinationActor, exit.getName()));


                    }

                }
                else if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    if(actor.getWeaponInventory().size()!=0){
                        WeaponItem weapon = actor.getWeaponInventory().get(0);
                        if(weapon.hasCapability(Status.HAS_AOE_ATTACK_SKILL)){
                            return weapon.getSkill(actor);
                        }
                        else{
                            return new AttackAction(destinationActor,exit.getName(),weapon);
                        }
                    }
                    return new AttackAction(destinationActor, exit.getName());
                }

            }
        }

        if(!actions.isEmpty()){
            return actions.get(random.nextInt(actions.size()));
        }
        else{
            return null;
        }
















        // GET ALL THE ATTACKABLE TARGETS
//        HashMap<Integer, Actor> attackableList = new HashMap<Integer, Actor>();
//        HashMap<Integer, Exit> enemyCoordinates = new HashMap<Integer, Exit>();
//
//        int counter = 2;
//        Location currentLoc = map.locationOf(actor);
//        for(Exit exits: currentLoc.getExits()) {
//            Location destination = exits.getDestination();
//            if (destination.containsAnActor()) {
//                Actor destinationActor = destination.getActor();
//                if (destinationActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
//                    if(destinationActor.getDisplayChar()!= actor.getDisplayChar()){
//                        attackableList.put(counter,destinationActor);
//                        enemyCoordinates.put(counter,exits);
//                        counter++;
//                    }
//
//                }
//                else if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//                    attackableList.put(1,destinationActor);
//                    enemyCoordinates.put(1,exits);
//                }
//
//            }
//
//        }
//
//        // IF THERE ARE TARGETS TO ATTACK
//        if(!attackableList.isEmpty()){
//            // ELSE IT WILL JUST ATTACK THE FIRST TARGET WHICH IS PRIO TO PLAYER
//            Map.Entry<Integer,Actor> attackableIterator = attackableList.entrySet().iterator().next();
//            Map.Entry<Integer,Exit> coordinateIterator = enemyCoordinates.entrySet().iterator().next();
//            if(actor.getWeaponInventory().size()!=0){
//                WeaponItem attackWeapon = actor.getWeaponInventory().get(0);
//                if(attackWeapon.hasCapability(Status.HAS_AOE_ATTACK_SKILL)){
//                    return attackWeapon.getSkill(actor);
//                }
//                else{
//                    return new AttackAction(attackableIterator.getValue(),coordinateIterator.getValue().getName(),attackWeapon);
//                }
//            }
//            else {
//                return new AttackAction(attackableIterator.getValue(),coordinateIterator.getValue().getName());
//            }
//
//
//
//            }
            //return null;
        }




}


