package game.action_types.reset;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;

/**
 * The ResetAction class that will cause a reset
 * @author Aaren Wong
 * @see Action
 * @version 1.0.0
 */
public class ResetAction extends Action {
    /**
     * Perform the reset action
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
             Location spawnpoint = ResetManager.getInstance().getSpawnPoint();
             GameMap respawnMap = spawnpoint.map();
             respawnMap.at(spawnpoint.x(), spawnpoint.y()).addActor(actor);
        }
        ResetManager.getInstance().run();
        return actor + " respawned";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
