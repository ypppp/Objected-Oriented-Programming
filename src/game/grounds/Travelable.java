package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface for objects that are travelable
 * @author Tong Jet Kit
 * @version 1.0
 */
public interface Travelable {

    /**
     * To get the destination of the travel
     * @return The location of the destination
     */

    Location getDestinationLocation();

    /**
     * The toString method for a travelable object to get the description of the object
     * @return A string which represents the description of a travelable object
     */
    String toString();

    /**
     * To travel to the destination
     * @param actor The actor that is travelling
     * @param map The current map where the actor is in right now
     */
    void travel(Actor actor, GameMap map);
}
