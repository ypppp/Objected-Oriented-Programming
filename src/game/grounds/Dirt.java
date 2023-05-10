package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Dirt extends Ground {

	/**
	 * Constructor for a dirt ground
	 */
	public Dirt() {
		super('.');
		this.addCapability(Status.CAN_HAVE_GOLDEN_RUNES);
	}
}
