package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Species;
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
                currentActor.hurt(Integer.MAX_VALUE);
            }
        }
    }

    /**
     * To determine if an actor can move to the ground
     * @param actor the Actor to check
     * @return True if the actor can enter; false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return (actor.hasCapability(Status.HOSTILE_TO_ENEMY) && !actor.hasCapability(Species.ALLY));
    }
}
