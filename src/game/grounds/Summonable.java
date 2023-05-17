package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

public interface Summonable {
    void summon(Location location, Actor actor);
    Location getLocation();
}
