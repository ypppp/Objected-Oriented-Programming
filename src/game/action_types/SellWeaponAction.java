package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.entity.npc.Trader;
import game.items.runes.RuneManager;

public class SellWeaponAction extends Action {

    private Trader trader;
    private int buyAmount;
    private WeaponItem weapon;


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

        actor.removeWeaponFromInventory(weapon);
        RuneManager.getInstance().addRunes(buyAmount);
        return weapon + "sell by " + actor + " to " + trader;

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
