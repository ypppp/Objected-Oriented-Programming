package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.GiantCrab;

import java.util.Random;

/**
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public class PuddleOfWater extends Ground {
    private RandomNumberGenerator rng = new RandomNumberGenerator();

    public PuddleOfWater() {
        super('~');
    }

    public void tick(Location location) {
        int randomInt = rng.getRandomInt(100);
        randomInt = randomInt + 1;
        if((randomInt > 0 && randomInt < 3) && !location.containsAnActor()){
            location.addActor(new GiantCrab());
        }

    }


}
