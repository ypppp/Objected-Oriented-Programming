package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.entity.npc.Trader;
import game.items.runes.RuneManager;

public class SellItemAction extends Action {
    /**
     * The trader that the player will be selling its item to
     */
    private Trader trader;

    /**
     * The market selling amount of the item
     */
    private int buyAmount;

    /**
     * The item that is sold to the trader
     */
    private Item item;
    /**
     * Constructor for the action to sell an item
     * @param trader The trader that the player will be selling to
     * @param item The item that the player is selling
     * @param buyAmount The selling amount of the player
     */
    public SellItemAction(Trader trader, Item item, int buyAmount) {
        this.trader = trader;
        this.buyAmount = buyAmount;
        this.item = item;
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
        actor.removeItemFromInventory(item);
        String runeAmount = RuneManager.getInstance().addRunes(buyAmount);
        result+= item + "sell by " + actor + " to " + trader + "\n";
        result += actor + " has " + runeAmount + "runes";
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
        return "I am " + trader +  ", Purveyor of fine goods. I would like to buy your " + item;
    }
}
