package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action_types.TravelAction;

public class GoldenFogDoor extends Ground {

    private Location travelDestination;
    private String destinationName;

    /**
     * Constructor.
     */
    public GoldenFogDoor(Location travelDestination, String destinationName) {
        super('D');
        this.travelDestination = travelDestination;
        this.destinationName = destinationName;
    }

    public Location getTravelDestination() {
        return travelDestination;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new TravelAction(getTravelDestination(),destinationName));
        return actions;
    }
}
