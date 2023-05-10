package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.entity.npc.Trader;
import game.items.Exchangeable;

public class ExchangeAction extends Action {
    private Item item;
    private Trader trader;
    private WeaponItem weapon;


    public ExchangeAction(Trader trader, Item item, WeaponItem weapon){
        this.trader = trader;
        this.item = item;
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
        actor.removeItemFromInventory(item);
        result+= item + " was exchanged by " + actor + " to " + trader + " for " + weapon + "\n";
        actor.addWeaponToInventory(weapon);
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
        return "I am " + trader +  ". I would like to exchange your "+ item +" for " + weapon;
    }
}
