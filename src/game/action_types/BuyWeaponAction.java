package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.entity.npc.Trader;
import game.items.runes.RuneManager;

/**
 * An action to buy a weapon from the trader
 * @author Tong Jet Kit
 * @Version 1.0
 * @see Action
 */
public class BuyWeaponAction extends Action {

    /**
     * The weapon to buy from the
     */
    private WeaponItem weapon;

    private int sellingAmount;
    private Trader trader;

    /**
     * Constructor for BuyWeaponAction
     * @param trader The trader that the player is buying from
     * @param weapon The weapon that the player is buying
     * @param sellingAmount The selling amount of the weapon
     */

    public BuyWeaponAction(Trader trader, WeaponItem weapon, int sellingAmount) {
        this.weapon = weapon;
        this.sellingAmount = sellingAmount;
        this.trader = trader;
    }

    /**
     * Perform the Action to buy a weapon.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if(RuneManager.getInstance().canMakePurchase(sellingAmount)){
            String result = "";
            actor.addWeaponToInventory(weapon);
            String runeAmount = RuneManager.getInstance().removeRunes(sellingAmount);
            result+= weapon + "bought by " + actor + " from " + trader;
            result += actor + " has " + runeAmount + "runes";
            return result;
        }
        else{
            return actor + " does not have enough runes";
        }

    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return "I am Kale, Purveyor of fine goods. Would you like to buy a " + weapon;
    }

}
