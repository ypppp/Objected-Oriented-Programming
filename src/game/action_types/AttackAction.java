package game.action_types;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Status;


/**
 * An Action to attack another Actor.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Aaron Wong Cong Ming
 *
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	private Actor target;

	/**
	 * The direction of incoming attack.
	 */
	private String direction;

	/**
	 * Random number generator
	 */
	private Random rand = new Random();

	/**
	 * Weapon used for the attack
	 */
	private Weapon weapon;


	/**
	 * Constructor.
	 *
	 * @param target the Actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 * @param weapon the weapon that is used in this attack
	 */
	public AttackAction(Actor target, String direction, Weapon weapon) {
		this.target = target;
		this.direction = direction;
		this.weapon = weapon;

	}

	/**
	 * Constructor with intrinsic weapon as default
	 *
	 * @param target the actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}


	/**
	 * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
	 * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
	 *
	 * @param actor The actor performing the attack action.
	 * @param map The map the actor is on.
	 * @return the result of the attack, e.g. whether the target is killed, etc.
	 * @see DeathAction
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		if (weapon == null) {
			weapon = actor.getIntrinsicWeapon();
		}

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage =  weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);
		if (!target.isConscious() && target.hasCapability(Status.HOSTILE_TO_PLAYER)) {
			result += new DeathAction(actor).execute(target, map);
		}

		return result;
	}

	/**
	 * Getter to return a Random object
	 * @return A Random object
	 */
	public Random getRand() {
		return rand;
	}

	/**
	 * To get the target
	 * @return An actor that is the target
	 */
	public Actor getTarget() {
		return target;
	}

	/**
	 * To get the direction of the attack
	 * @return A string which states the direction of the attack
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * To get the weapon of the attack
	 * @return The weapon of the attack
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Describes which target the actor is attacking with which weapon
	 *
	 * @param actor The actor performing the action.
	 * @return a description used for the menu UI
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
	}


}
