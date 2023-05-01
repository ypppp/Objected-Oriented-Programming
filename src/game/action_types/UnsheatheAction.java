package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;

import java.util.Random;


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

    public UnsheatheAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
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

    /**
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes to attack " + target + " at " + direction + " with " + weapon;
    }
}
