package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.HeavySkeletonSwordsman;
import game.entity.enemies.LoneWolf;

/**
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public class Graveyard extends Ground {

    public Graveyard() {
        super('n');
    }

    public void tick(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)<28 && !location.containsAnActor()){
            location.addActor(new HeavySkeletonSwordsman());
        }

    }
}
