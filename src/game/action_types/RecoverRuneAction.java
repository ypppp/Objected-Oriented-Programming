package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.items.runes.Rune;
import game.items.runes.RuneManager;

/**
 * The RecoverRuneAction that allows the player to recover the dropped runes
 * @author Aaren Wong
 * @see Action
 * @version 1.0.0
 */
public class RecoverRuneAction extends Action {
    /**
     * A Rune class attriu=bute
     */
    private Rune runes;

    /**
     * The constructor of the RecoverRuneAction class
     * @param runes
     */
    public RecoverRuneAction(Rune runes) {
        this.runes = runes;
    }

    /**
     * Perform the recover runes action that allows the player to pick up the dropped runes and updates the rune count of the player
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            result += actor + " retrieved Runes (value: " +runes.getAmount() + ")";
            RuneManager.getInstance().addRunes(runes.getAmount());
            map.locationOf(actor).removeItem(runes);
            RuneManager.getInstance().setRuneLocation(null);
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
        return actor + " retrieves Runes (value: " + runes.getAmount() + ")";
    }
}
