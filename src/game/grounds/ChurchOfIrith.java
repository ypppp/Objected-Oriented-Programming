package game.grounds;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action_types.PrayAction;

/**
 * The ground for which the player can pray upon to obtain a blessing or a curse from Godrick the Grafted
 * @author Tong Jet Kit
 * @see Ground
 * @version 1.0
 */
public class ChurchOfIrith extends Ground {
    /**
     * Constructor.
     */
    public ChurchOfIrith() {
        super('^');
    }

    /**
     * To determine if an actor can enter
     * @param actor the Actor to check
     * @return Ture if the actor can; false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * To return a collection of actions that the actor can do while on this ground
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a collection of actions that the actor can do while on this ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new PrayAction());
        return actions;
    }
}
