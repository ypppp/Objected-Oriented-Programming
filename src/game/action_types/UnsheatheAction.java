package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;

import java.util.Random;

/**
 * An action to perform the skill of Uchigatana
 * @author Tong Jet Kit
 * @Version 1.0
 * @see Action
 */
public class UnsheatheAction extends Action {

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

    /**
     * Constructor
     * @param target The actor to attack
     * @param direction The direction where the attack should be performed (only used for display purposes)
     * @param weapon The weapon used in the attack
     */

    public UnsheatheAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Perform an unsheathe skill action
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A string that is the execution of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // check if miss or not
        if (!(RandomNumberGenerator.getRandomInt(100) < 60)) {
            return actor + " misses " + target + ".";
        }
        // else do dmg where the dmg is *2
        int damage =  weapon.damage()*2;
        String result = actor + " unsheathes and " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);

        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }

        return result;
    }

    /** Describes which target the actor is attacking with which weapon
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes to attack " + target + " at " + direction + " with " + weapon;
    }
}
