package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.GiantCrayfish;
import game.entity.enemies.LoneWolf;

import java.util.Random;

/**
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public class PuddleOfWater extends Ground {

    public PuddleOfWater() {
        super('~');
    }

    public void tick(Location location) {
        if (location.x() >= 40) {
            if ((RandomNumberGenerator.getRandomInt(100)<2 && !location.containsAnActor()))
            {
                location.addActor(new GiantCrayfish());
            }
        }
        else if (location.x() < 40){
            if ((RandomNumberGenerator.getRandomInt(100)<3 && !location.containsAnActor()))
            {
                location.addActor(new GiantCrab());
            }
            }
        }


}
