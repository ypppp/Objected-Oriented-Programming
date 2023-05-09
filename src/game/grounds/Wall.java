package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {

	/**
	 * Constructor for a wall ground
	 */
	public Wall() {
		super('#');
	}

	/**
	 * To determine if an actor can move to the ground
	 * @param actor the Actor to check
	 * @return True if an actor can move to the ground; false otherwise
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * To determine whether an object can be thrown over the ground
	 * @return True if an object can be thrown over; false otherwise
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
