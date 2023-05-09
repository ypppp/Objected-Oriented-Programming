package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.grounds.TheSiteOfLostGrace;
import game.action_types.reset.ResetAction;
import game.action_types.reset.ResetManager;

/**
 * The RestAction class which allows the player to rest at the site
 * @author Aaren Wong
 * @see Action
 * @version 1.0.0
 */
public class RestAction extends Action {
    /**
     * A TheSiteOfLostGrace class attribute
     */
    private TheSiteOfLostGrace theSiteOfLostGrace;

    /**
     * The constructor of the RestAction class
     * @param theSiteOfLostGrace The site of lost grace
     */
    public RestAction(TheSiteOfLostGrace theSiteOfLostGrace) {
        this.theSiteOfLostGrace = theSiteOfLostGrace;
    }

    /**
     * Perform the rest action which allows a player to rest at the site and causes a reset
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            ResetManager.getInstance().run();
        }
        result += actor + " rests at " + theSiteOfLostGrace.getName();
        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rests at " + theSiteOfLostGrace.getName();
    }
}
