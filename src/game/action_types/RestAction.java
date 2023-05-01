package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.grounds.TheSiteOfLostGrace;
import game.reset.ResetAction;
import game.reset.ResetManager;

public class RestAction extends Action {

    private TheSiteOfLostGrace theSiteOfLostGrace;

    public RestAction(TheSiteOfLostGrace theSiteOfLostGrace) {
        this.theSiteOfLostGrace = new TheSiteOfLostGrace();
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
        String result = "";
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            ResetManager.getInstance().run();
        }
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
        return actor + " rests at The First Step";
    }
}
