package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.items.runes.Rune;
import game.items.runes.RuneManager;

public class RecoverRuneAction extends Action {

    private Rune runes;

    public RecoverRuneAction(Rune runes) {
        this.runes = runes;
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
