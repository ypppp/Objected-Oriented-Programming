package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action_types.TravelAction;

public class GoldenFogDoor extends Ground implements Travelable{

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


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new TravelAction(this));
        return actions;
    }

    /**
     * @return
     */
    @Override
    public Location getDestinationLocation() {
        return travelDestination;
    }

    public String toString(){
        return destinationName;
    }

    /**
     *
     */
    @Override
    public void travel(Actor actor, GameMap map) {
        map.moveActor(actor,getDestinationLocation());
    }
}
