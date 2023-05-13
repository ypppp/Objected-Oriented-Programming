package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The Barrack class which is one of the spawning grounds in the game
 * @author Yew Yee Perng
 * @see SpawningGrounds
 * @version 1.0
 */
public class Barrack extends SpawningGrounds{
    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
    }

    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().createGodrick(location);
        if (enemy != null) {
            location.addActor(enemy);
        }


    }
}
