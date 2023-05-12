package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.GiantCrayfish;
import game.entity.enemies.GiantDog;
import game.entity.enemies.LoneWolf;

/**
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public class GustOfWind extends SpawningGrounds {

    public GustOfWind() {
        super('&');
    }


    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().createCanine(location);
        if (enemy != null){
            location.addActor(enemy);
        }
    }
}
