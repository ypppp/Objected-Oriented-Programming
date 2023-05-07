package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.items.Consumables;
import game.items.FlaskOfCrimsonTears;

import java.nio.file.StandardCopyOption;

/**
 * The ConsumeActionclass that will allow the player to consume an item
 * @author Aaren Wong
 * @see Action
 * @version 1.0.0
 */
public class ConsumeAction extends Action {
    /**
     * A Consumables class attribute
     */
    private Consumables consumables;

    /**
     * The constructor of the ConsumeAction class
     * @param consumables The consumable item
     */
    public ConsumeAction(Consumables consumables) {
        this.consumables = consumables;
    }

    /**
     * Perform the consume action which will heal the player if there are still uses left
     *
     * @param player The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor player, GameMap map) {
        String result = "";

        if (consumables.getUses()>0 && player.hasCapability(Status.HOSTILE_TO_ENEMY)){
            result += consumables.consume(player);
        } else {
            result += consumables + consumables.printNumberOfUses() + " is empty";
        }

        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param player The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor player) {
        return player + " consumes " + consumables + consumables.printNumberOfUses();
    }
}
