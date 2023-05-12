package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public class Graveyard extends SpawningGrounds {


    public Graveyard() {
        super('n');
    }


    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().createSkeleton(location);
        if (enemy != null){
            location.addActor(enemy);
        }
    }
}
