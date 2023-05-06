package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.GiantCrayfish;
import game.entity.enemies.LoneWolf;

import java.util.Random;

/**
 * The PuddleOfWater class which is one of the spawning grounds in the game
 * @author Aaren Wong Cong Ming
 * Modified by: Yew Yee Perng
 * @see SpawningGrounds
 * @Version 1.0
 */
public class PuddleOfWater extends SpawningGrounds {
    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
    }


}
