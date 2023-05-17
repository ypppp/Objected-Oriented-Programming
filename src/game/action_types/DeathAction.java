package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.action_types.reset.Resettable;
import game.entity.creep.Creep;
import game.entity.creep.SummonedManager;
import game.entity.enemies.PileOfBones;
import game.items.runes.Rune;
import game.items.runes.RuneManager;
import game.action_types.reset.ResetAction;
import game.action_types.reset.ResetManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tong Jet Kit Aaren Wong Cong Ming
 *
 */
public class DeathAction extends Action {

    /**
     * The attacker in this kill situation
     */
    private Actor attacker;

    /**
     * Constructor
     * @param actor An actor which is the attacker
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * Perform the action to die if killed
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        ActionList dropActions = new ActionList();
        // drop all items

        if (!target.hasCapability(Status.HOSTILE_TO_ENEMY) || target.hasCapability(Species.ALLY)){
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
        }

        // remove actor
        if (target.hasCapability(Species.ALLY) || target.hasCapability(Species.INVADER)){
            SummonedManager.getInstance().removeCreep(target);
            map.removeActor(target);
        }
        else if (target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            if ((!target.hasCapability(Species.BONE)) || target.hasCapability(Status.RESPAWNABLE)) {
                map.removeActor(target);
            }
            else {
                Location skeletonLoc = map.locationOf(target);
                map.removeActor(target);
                PileOfBones skeleton = new PileOfBones(target);
                map.addActor(skeleton, skeletonLoc);
            }

        }


        // drop runes
        else {
            RuneManager.getInstance().dropRuneByDeath();
            map.removeActor(target); // player dies
            SummonedManager.getInstance().del(map);  // remove ally and invader from the map

            return new ResetAction().execute(target, map);
        }
        result += System.lineSeparator() + menuDescription(target);

        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY) && !attacker.hasCapability(Species.ALLY)) { // if a player but not ally
//
            if (target.hasCapability(Status.CAN_DROP_RUNES)) {
                String runeAmount = RuneManager.getInstance().runesDroppedByEnemies(target.getDisplayChar());
                result += System.lineSeparator() + attacker + " gets " + runeAmount + "runes from " + target;
            }
        }
        return result;

    }

    /**
     * Describes which actor died
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
