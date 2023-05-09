package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.RestAction;

/**
 * A place for the player to rest
 * @author Aaren Wong
 * @see Ground
 * @version 1.0
 */
public class TheSiteOfLostGrace extends Ground {

    /**
     * name of the site of lost grace
     */
    private String name;

    /**
     * Constructor
     * @param name A string which represents the name of the site of lost grace
     */
    public TheSiteOfLostGrace(String name) {
        super('U');
        this.name = name;
    }

    /**
     * A getter to get the name of the site of lost grace
     * @return A string which is the name of the site of lost grace
     */
    public String getName() {
        return name;
    }

    /**
     * To set the name of the site of lost grace
     * @param name The name of the site of lost grace
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To return the actions that the actor can be doing while on this ground
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of actions that the actor can be doing while on this ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList restAction = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            restAction.add(new RestAction(this));
            return restAction;
        }
        return restAction;
    }
}
