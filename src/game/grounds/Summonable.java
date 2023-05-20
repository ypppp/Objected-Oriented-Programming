package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

/**
 * This is the Summonable interface
 * @author Aaren Wong
 * @version 1.0.0
 */
public interface Summonable {
    /**
     * The summon method
     * @param location
     * @param actor
     */
    void summon(Location location, Actor actor);

    /**
     * To get the location to summon
     * @return
     */
    Location getLocation();
}
