package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.enemyweapons.Grossmesser;
import game.weapons.enemyweapons.Scimitar;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The pile of bones that spawns after a skeleton enemy dies and will respawn after not being hit
 * @author Tong Jet Kit
 * @Version 1.0
 * @see Enemy
 */
public class PileOfBones extends Enemy{

    private int counter = 3;
    private Actor revivedEnemy;

    /**
     * Constructor.
     */
    public PileOfBones(Actor enemy) {
        super("Pile of Bones", 'X',1);
        this.setBehaviours(new HashMap<>());
        this.addCapability(Status.CAN_DROP_RUNES);
        this.addCapability(Species.BONE);
        this.addCapability(Status.RESPAWNABLE);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        WeaponItem weapon = enemy.getWeaponInventory().get(0);
        weapon.togglePortability();
        this.addWeaponToInventory(weapon);
        enemy.removeWeaponFromInventory(weapon);
        this.revivedEnemy = enemy;

    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // if counter becomes 0 then revive to the revivedEnemy
        // by removing the actor on that location then adding the revivedEnemy.
        if (this.hasCapability(Status.RESET)){
            this.removeCapability(Status.RESET);
            return despawn();
        }

        if(counter==0){
            Location here = map.locationOf(this);
            map.removeActor(this);
            WeaponItem weapon = this.getWeaponInventory().get(0);
            weapon.togglePortability();
            revivedEnemy.addWeaponToInventory(weapon);
            map.addActor(revivedEnemy, here);
            display.println(this.revivedEnemy + " has been revived");
        }

        counter--;

        return new DoNothingAction();
    }


}
