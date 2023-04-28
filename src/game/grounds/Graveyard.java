package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.*;

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
        if (location.x() > 40 && (RandomNumberGenerator.getRandomInt(100)<28 && !location.containsAnActor())){
            location.addActor(new SkeletonBandit());}
        else if ((RandomNumberGenerator.getRandomInt(100)<28 && !location.containsAnActor()))
        {
            location.addActor(new HeavySkeletonSwordsman());}

    }
}
