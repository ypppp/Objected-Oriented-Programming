package game.entity.npc;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.BuyWeaponAction;
import game.action_types.ExchangeAction;
import game.action_types.SellItemAction;
import game.action_types.SellWeaponAction;
import game.items.Exchangeable;
import game.items.Purchasable;
import game.items.RemembranceOfTheGrafted;
import game.items.Sellable;
import game.weapons.enemyweapons.Scimitar;
import game.weapons.exchangeableweapons.AxeOfGodric;
import game.weapons.exchangeableweapons.GraftedDragon;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Staff;
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
    HashMap<String, Sellable> sellables = new HashMap<>();

    /**
     * An arraylist of purchasable weapons that the trader can sell to the player
     */
    ArrayList<Purchasable> purchasables = new ArrayList<>();

    HashMap<String,Exchangeable>exchangeables = new HashMap<>();

    /**
     * Constructor.
     */
    public Trader(String name, char displayChar,ArrayList<Status>status) {
        super(name,displayChar,0);
        for (Status traderStatus:status){
            this.addCapability(traderStatus);
        }
        sellables.put("Club",new Club());
        sellables.put("Uchigatana", new Uchigatana());
        sellables.put("Great Knife", new GreatKnife());
        sellables.put("Scimitar", new Scimitar());
        sellables.put("Remembrance of the Grafted", new RemembranceOfTheGrafted());
        sellables.put("Axe of Godric", new AxeOfGodric());
        sellables.put("Grafted Dragon", new GraftedDragon());
        sellables.put("Astrologer's Staff", new Staff());
        purchasables.add(new Club());
        purchasables.add(new Uchigatana());
        purchasables.add(new GreatKnife());
        purchasables.add(new Scimitar());
        purchasables.add(new Staff());
        exchangeables.put("Remembrance of the Grafted", new RemembranceOfTheGrafted());

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
            }


            if (this.hasCapability(Status.SELLABLE)){
                for(WeaponItem weapon: otherActor.getWeaponInventory()) {
                    if (weapon.hasCapability(Status.SELLABLE)) {
                        String weaponName = weapon.toString();
                        actions.add(new SellWeaponAction(this, weapon, sellables.get(weaponName).getSellPrice()));
                    }
                }
                for(Item item:otherActor.getItemInventory()){
                    if(item.hasCapability(Status.SELLABLE)){
                        String itemName = item.toString();
                        actions.add(new SellItemAction(this,item,sellables.get(itemName).getSellPrice()));
                    }
                }
            }


            if (this.hasCapability(Status.EXCHANGEABLE)){
                for (Item item:otherActor.getItemInventory()){
                    if(item.hasCapability(Status.EXCHANGEABLE)){
                        Exchangeable exchangeableItem = exchangeables.get(item.toString());
                        for (WeaponItem weapon: exchangeableItem.getExchangeItem().values()){
                            actions.add((new ExchangeAction(this,item, weapon)));
                        }
                    }

                }
            }

        }
        return actions;
    }
}

