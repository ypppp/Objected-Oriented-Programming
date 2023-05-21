package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {

	/**
	 * Constructor for a floor ground
	 */
	public Floor() {
		super('_');
		this.addCapability(Status.CAN_HAVE_GOLDEN_RUNES);
	}

	/**
	 * To determine if an actor can move to the ground
	 * @param actor the Actor to check
	 * @return True if the actor can enter; false otherwise
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
}
