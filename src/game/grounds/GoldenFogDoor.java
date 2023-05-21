package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Species;
import game.Status;
import game.action_types.TravelAction;

/**
 * A special door that allows a player to travel to another map
 * @author Tong Jet Kit
 * @version 1.0
 * @see Ground
 * @see Travelable
 */
public class GoldenFogDoor extends Ground implements Travelable{

    /**
     * The destination of traveling through the door
     */
    private Location travelDestination;

    /**
     * The name of the destination
     */
    private String destinationName;

    /**
     * Constructor.
     * @param travelDestination The location of the destination
     * @param  destinationName The name of the destination
     */
    public GoldenFogDoor(Location travelDestination, String destinationName) {
        super('D');
        this.travelDestination = travelDestination;
        this.destinationName = destinationName;
    }


    /**
     * Return a list of actions that an actor can be doing when on this ground
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of actions that an actor can be doing when on this ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new TravelAction(this));
        return actions;
    }

    /**
     * Getter to get the location of the travel destination
     * @return The location of the travel destination
     */
    @Override
    public Location getDestinationLocation() {
        return travelDestination;
    }

    /**
     * The toString method of this class to return a description of the object
     * @return A string which is the name of the destination
     */
    public String toString(){
        return destinationName;
    }

    /**
     * To travel to the destination
     * @param actor The actor that is travelling
     * @param map The map that the actor is in right now
     */
    @Override
    public void travel(Actor actor, GameMap map) {
        map.moveActor(actor,getDestinationLocation());
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return (actor.hasCapability(Status.HOSTILE_TO_ENEMY) && !actor.hasCapability(Species.ALLY));
    }
}
