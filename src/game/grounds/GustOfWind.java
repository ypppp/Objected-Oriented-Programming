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
 * The GustOfWind class which is one of the spawning grounds in the game
 * @author Aaren Wong Cong Ming
 * Modified by: Yew Yee Perng
 * @see SpawningGrounds
 * @version 1.0
 */
public class GustOfWind extends SpawningGrounds {
    /**
     * Constructor.
     */
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
