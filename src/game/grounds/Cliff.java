package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

public class Cliff extends Ground {
    /**
     * Constructor.
     */
    public Cliff(){
        super('+');
    }

    @Override
    public void tick(Location location) {
        if(location.containsAnActor()){
            Actor currentActor = location.getActor();
            if(currentActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                currentActor.hurt(999999999);
            }
        }
    }
}
