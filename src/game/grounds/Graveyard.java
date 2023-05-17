package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The Graveyard class which is one of the spawning grounds in the game
 * @author Aaren Wong Cong Ming
 * Modified by: Yew Yee Perng
 * @see SpawningGrounds
 * @version 1.0
 */
public class Graveyard extends SpawningGrounds {
    /**
     * Constructor.
     */
    public Graveyard() {
        super('n');
    }

    /**
     * To spawn the enemy at that current location
     * @param location The location of where the enemy will spawn
     */
    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().createSkeleton(location);
        if (enemy != null) {
            location.addActor(enemy);
        }


    }
}
