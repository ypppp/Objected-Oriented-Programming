package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.Species;
import game.Status;
import game.action_types.ConsumeAction;
import game.action_types.SummonAction;
import game.entity.creep.Ally;
import game.entity.creep.Creep;
import game.entity.creep.SummonedManager;
import game.entity.enemies.LoneWolf;

public class SummonSign extends Ground implements Summonable {
    private Location location;

    /**
     * Constructor.
     *
     */
    public SummonSign(Location location) {
        super('=');
        this.location = location;

    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new SummonAction(this));
        }
        return actions;
    }

    @Override
    public void summon(Location location, Actor actor) {
        location.addActor(actor);
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
