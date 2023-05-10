package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.FancyMessage;
import game.grounds.Activatable;
import game.grounds.TheSiteOfLostGrace;

/**
 * An action to activate an object
 * @author Tong Jet Kit
 * @see Action
 * @version 1.0
 */
public class ActivateAction extends Action {

    /**
     * An activatable object
     */
    private Activatable activatable;

    /**
     * Constructor
     * @param activatable The activable object that we are activating through this action
     */
    public ActivateAction(Activatable activatable) {
        this.activatable = activatable;
    }

    /**
     * Perform the activating action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        activatable.activate();
        for (String line : FancyMessage.DISCOVERED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return activatable + " has been activated";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " activate " + activatable;
    }
}
