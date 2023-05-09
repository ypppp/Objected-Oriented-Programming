package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface Travelable {

    Location getDestinationLocation();

    String toString();

    void travel(Actor actor, GameMap map);
}
