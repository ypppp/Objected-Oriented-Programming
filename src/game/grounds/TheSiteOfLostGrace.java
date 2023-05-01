package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.RestAction;

public class TheSiteOfLostGrace extends Ground {
//    private String name;
    public TheSiteOfLostGrace() {
        super('U');
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Exit exit : location.getExits()){
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor destinationActor = destination.getActor();
                if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    actions.add(new RestAction(this));
                }
            }

        }
        return actions;
    }
}
