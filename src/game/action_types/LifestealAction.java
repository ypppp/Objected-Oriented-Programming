package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.RandomNumberGenerator;
import game.Status;

import java.util.Random;

/**
 * An attack that not only damages the target but heal the user
 * @author Tong Jet Kit
 * @see Action
 * @version 1.0
 */
public class LifestealAction extends Action {

    /**
     * The target of the attack
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
     * Constructor for when the action warrants an intrinsic weapon
     * @param target The target which we will be attacking
     * @param direction The direction of the attack
     */
    public LifestealAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Constructor for when the action uses a weapon
     * @param target The target which we will be attacking
     * @param direction The direction of the attack
     * @param weapon The weapon used in the attack
     */
    public LifestealAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the lifesteal attack
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }
//
//        if (!(RandomNumberGenerator.getRandomInt(100) <= weapon.chanceToHit())) {
//            return actor + " misses " + target + ".";
//        }
//
//        int damage =  weapon.damage();
//        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage";
//        target.hurt(damage);
//
//        if (!target.isConscious() && target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
//            result += new DeathAction(actor).execute(target, map);
//        }

        String result = new AttackAction(target, direction).execute(actor, map);
        Float healAmount = weapon.damage()*0.4f;
        actor.heal(Math.round(healAmount));
        result += System.lineSeparator() + actor + " healed for " + healAmount;

        return result;
    }

    /**
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        String desc = actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
        desc += " to steal some health";
        return desc;
    }
}
