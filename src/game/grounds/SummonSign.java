package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.SummonAction;

/**
 * The SummonSign class which is a ground that allows the player to summon an ally or invader by chance
 * @author Aaren Wong
 * @version 1.0.0
 * @see Ground
 * @see Summonable
 */
public class SummonSign extends Ground implements Summonable {
    /**
     * A private instance of the Location class
     */
    private Location location;

    /**
     * Constructor.
     */
    public SummonSign(Location location) {
        super('=');
        this.location = location;

    }

    /**
     * Allows a SummonAction if a player is near it
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return the summon action
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new SummonAction(this));
        }
        return actions;
    }

    /**
     * The location to summon
     * @param location the location to summon
     * @param actor the actor to be summoned
     */
    @Override
    public void summon(Location location, Actor actor) {
        location.addActor(actor);
    }

    /**
     * The location of the summon sign
     * @return the location of the summon sign
     */
    @Override
    public Location getLocation() {
        return location;
    }
}
