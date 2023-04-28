package game.grounds;

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

public class GustOfWind extends Ground {

    public GustOfWind() {
        super('&');
    }

    public void tick(Location location) {
        if (location.x() > 40 && (RandomNumberGenerator.getRandomInt(100)<5 && !location.containsAnActor())){
            location.addActor(new GiantDog());}
        else if ((RandomNumberGenerator.getRandomInt(100)<34 && !location.containsAnActor()))
        {
            location.addActor(new LoneWolf());}

    }
}
