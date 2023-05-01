package game.reset;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.DespawnAction;

import javax.swing.plaf.synth.SynthTableUI;

public class ResetAction extends Action {
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
             Location spawnpoint = ResetManager.getInstance().getSpawnPoint();
             map.at(spawnpoint.x(), spawnpoint.y()).addActor(actor);
        }
        ResetManager.getInstance().run();
        return actor + " respawn at The First Step";
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