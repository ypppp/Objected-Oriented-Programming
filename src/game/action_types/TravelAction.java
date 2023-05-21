package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.FancyMessage;
import game.grounds.Travelable;

/**
 * An action to fast travel
 * @author Tong Jet Kit
 * @see Action
 */
public class TravelAction extends Action {

    /**
     * A travelable object
     */
    private Travelable travelable;


    /**
     * Constructor
     * @param travelable The travelable object
     */
    public TravelAction(Travelable travelable) {
        this.travelable = travelable;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        travelable.travel(actor,map);
        FancyMessage.printMessage(travelable.toString());
        return menuDescription(actor);
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travel to " + travelable;
    }
}
