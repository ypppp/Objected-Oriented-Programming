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

    public void tick(Location location) {

        if(location.x()>=40){
            if(getFactory()==null){
                this.setFactory(new EastEnemyFactory());
            }
            this.spawn(location);

        }
        else if(location.x()<40){
            if(getFactory()==null){
                this.setFactory(new WestEnemyFactory());
            }
            this.spawn(location);
        }



//        if (location.x() >= 40) {
//            if ((RandomNumberGenerator.getRandomInt(100) < 28 && !location.containsAnActor())) {
//                location.addActor(new SkeletonBandit());
//            }
//        }
//        else if (location.x() < 40) {
//            if (((RandomNumberGenerator.getRandomInt(100)<28 && !location.containsAnActor()))) {
//                location.addActor(new HeavySkeletonSwordsman());
//            }
//        }



    }

    /**
     * @param location
     */
    @Override
    public void spawn(Location location) {
        Actor enemy = getFactory().spawnEnemy(location, this.getDisplayChar());
        if(enemy != null){
            location.addActor(enemy);
        }
    }
}
