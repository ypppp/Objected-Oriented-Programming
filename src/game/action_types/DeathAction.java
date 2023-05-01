package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.Species;
import game.Status;
import game.entity.enemies.Enemy;
import game.entity.enemies.HeavySkeletonSwordsman;
import game.entity.enemies.PileOfBones;
import game.items.runes.Rune;
import game.items.runes.RuneManager;
import game.reset.ResetAction;
import game.reset.ResetManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class DeathAction extends Action {
    private Actor attacker;

    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
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

        if (!target.hasCapability(Status.HOSTILE_TO_ENEMY)){
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);
        }
        // remove actor

//        implement rune drops here - check if the attacker is player [if yes, get the rune drop values from infomanager and displaychar

        if (target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            if ((!target.hasCapability(Species.BONE))|| target.hasCapability(Status.RESPAWNABLE)) {
                map.removeActor(target);
            }
            else {
                Location skeletonLoc = map.locationOf(target);
                map.removeActor(target);
                PileOfBones skeleton = new PileOfBones(target);
                map.addActor(skeleton, skeletonLoc);
            }
        }
        else {
            if (RuneManager.getInstance().getRuneLocation() != null){
                RuneManager.getInstance().getRuneLocation().removeItem(RuneManager.getInstance().getDroppedRunes());
            }
            Rune runes = new Rune();
            runes.setAmount(RuneManager.getInstance().getRune().getAmount());
            RuneManager.getInstance().setDroppedRunes(runes);
            RuneManager.getInstance().removeRunes(RuneManager.getInstance().getRune().getAmount()); // player loses all the runes
            RuneManager.getInstance().getPlayerLocation().addItem(runes); // drops the rune
            RuneManager.getInstance().setRuneLocation(RuneManager.getInstance().getPlayerLocation()); // saves the rune location
            map.removeActor(target); // player dies

            return new ResetAction().execute(target, map);
        }
        result += System.lineSeparator() + menuDescription(target) + "\n";

        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
//
            if (target.hasCapability(Status.CAN_DROP_RUNES)) {
                String runeAmount = RuneManager.getInstance().runesDroppedByEnemies(target.getDisplayChar());
                result += attacker + " gets " + runeAmount + "runes from " + target;
            }
        }
        return result;

    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
