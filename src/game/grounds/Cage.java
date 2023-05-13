package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The Cage class which is one of the spawning grounds in the game
 * @author Yew Yee Perng
 * @see SpawningGrounds
 * @version 1.0
 */
public class Cage extends SpawningGrounds{
    /**
     * Constructor.
     */
    public Cage() {
        super('<');
    }

    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().createDog(location);
        if (enemy != null) {
            location.addActor(enemy);
        }


    }
}
