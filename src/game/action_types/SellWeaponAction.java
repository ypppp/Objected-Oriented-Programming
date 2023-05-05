package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.entity.npc.Trader;
import game.items.runes.RuneManager;

/**
 * An action to sell a weapon to the trader
 */
public class SellWeaponAction extends Action {

    /**
     * The trader that the player will be selling its weapon to
     */
    private Trader trader;

    /**
     * The market selling amount of the weapon
     */
    private int buyAmount;

    /**
     * The weapon that is sold to the trader
     */
    private WeaponItem weapon;


    /**
     * Constructor for the action to sell a weapon
     * @param trader The trader that the player will be selling to
     * @param weapon The weapon that the player is selling
     * @param buyAmount The selling amount of the player
     */
    public SellWeaponAction(Trader trader, WeaponItem weapon, int buyAmount) {
        this.trader = trader;
        this.buyAmount = buyAmount;
        this.weapon = weapon;
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
        actor.removeWeaponFromInventory(weapon);
        String runeAmount = RuneManager.getInstance().addRunes(buyAmount);
        result+= weapon + "sell by " + actor + " to " + trader + "\n";
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
        return "I am Kale, Purveyor of fine goods. I would like to buy your " + weapon;
    }
}
