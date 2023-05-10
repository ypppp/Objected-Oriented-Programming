package game.entity.npc;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.BuyWeaponAction;
import game.action_types.ExchangeAction;
import game.action_types.SellWeaponAction;
import game.items.Exchangeable;
import game.items.Purchasable;
import game.items.Sellable;
import game.weapons.enemyweapons.Scimitar;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Uchigatana;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The trader to trade weapons with the player
 * @author Tong Jet Kit
 * @version 1.0
 * @see Actor
 */
public class Trader extends Actor {

    /**
     * A hashmap of sellable weapons that the trader can buy from the player
     */
    HashMap<String, Sellable> weaponPrice = new HashMap<>();

    /**
     * An arraylist of purchasable weapons that the trader can sell to the player
     */
    ArrayList<Purchasable> purchasables = new ArrayList<>();

    ArrayList<Exchangeable>exchangeables = new ArrayList<>();

    /**
     * Constructor.
     */
    public Trader(String name, char displayChar,ArrayList<Status>status) {
        super(name,displayChar,0);
        for (Status traderStatus:status){
            this.addCapability(traderStatus);
        }
        weaponPrice.put("Club",new Club());
        weaponPrice.put("Uchigatana", new Uchigatana());
        weaponPrice.put("Great Knife", new GreatKnife());
        weaponPrice.put("Scimitar", new Scimitar());
        purchasables.add(new Club());
        purchasables.add(new Uchigatana());
        purchasables.add(new GreatKnife());
        purchasables.add(new Scimitar());
        System.out.println(name + this.capabilitiesList());



    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            if (this.hasCapability(Status.PURCHASABLE)){
                for(Purchasable purchasable: purchasables){
                    actions.add(new BuyWeaponAction(this, purchasable.getPurchaseItem(), purchasable.getPurchasePrice()));
                }
            } if (this.hasCapability(Status.SELLABLE)){
                for(WeaponItem weapon: otherActor.getWeaponInventory()) {
                    if (weapon.hasCapability(Status.SELLABLE)) {
                        String weaponName = weapon.toString();
                        actions.add(new SellWeaponAction(this, weapon, weaponPrice.get(weaponName).getSellPrice()));
                    }
                }
            } if (this.hasCapability(Status.EXCHANGEABLE)){
                for (Exchangeable exchangeableItems:exchangeables){
                    for (String exchangeName: exchangeableItems.getExchangeItem().keySet()){
                        actions.add((new ExchangeAction(this, exchangeableItems, exchangeName)));
                    }
                }
            }

        }
        return actions;
    }
}

