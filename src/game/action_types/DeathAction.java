package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.Species;
import game.Status;
import game.entity.enemies.Enemy;
import game.entity.enemies.HeavySkeletonSwordsman;
import game.entity.enemies.PileOfBones;
import game.items.runes.Rune;
import game.items.runes.RuneManager;
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
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // remove actor

//        implement rune drops here - check if the attacker is player [if yes, get the rune drop values from infomanager and displaychar

        if (target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            if (!target.hasCapability(Species.BONE)) {
                map.removeActor(target);
            } else {
                Location skeletonLoc = map.locationOf(target);
                map.removeActor(target);
                PileOfBones skeleton = new PileOfBones(target);
                map.addActor(skeleton, skeletonLoc);
            }
        } else {
            Rune runes = new Rune();
            runes.setAmount(RuneManager.getInstance().getRune().getAmount());
            RuneManager.getInstance().removeRunes(RuneManager.getInstance().getRune().getAmount()); // player loses all the runes\
            RuneManager.getInstance().getPlayerLocation().addItem(runes);
            map.removeActor(target); // player dies
            ResetManager.getInstance().run(); // reset the map
            for (String line : FancyMessage.YOU_DIED.split("\n")) { // display "YOU DIED"
                new Display().println(line);
                try {
                    Thread.sleep(200);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return result;
        }
        result += System.lineSeparator() + menuDescription(target) + "\n";

        if (attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
//
            if (target.hasCapability(Species.BONE) && target.hasCapability(Status.RESPAWNABLE)) {
                String runeAmount = RuneManager.getInstance().runesDroppedByEnemies(target.getDisplayChar());
                result += attacker + " gets " + runeAmount + "runes from " + target;
            } else if (!target.hasCapability(Species.BONE)){
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
