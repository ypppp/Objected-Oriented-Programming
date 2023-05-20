package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.weapons.exchangeableweapons.AxeOfGodric;
import game.weapons.exchangeableweapons.GraftedDragon;

import java.util.HashMap;

/**
 * The RemembranceOfTheGrafted class that can be exchanged and sold
 * @author Aaren Wong
 * @version 1.0.0
 * @see Item
 * @see Sellable
 * @see Exchangeable
 */
public class RemembranceOfTheGrafted extends Item implements Sellable, Exchangeable{
    /**
     * A hashmap to hold the weapons that it can be exchanged with
     */
    HashMap<String,WeaponItem> exchangeItem = new HashMap<>(){{
        put("Axe of Godric", new AxeOfGodric());
        put("Grafted Dragon", new GraftedDragon());
    }};

    /***
     * Constructor.
     */
    public RemembranceOfTheGrafted() {
        super("Remembrance of the Grafted", 'O', true);
        this.addCapability(Status.EXCHANGEABLE);
        this.addCapability((Status.SELLABLE));
    }


    /**
     * Gets the selling price of the item
     * @return An integer that is the selling price of this weapon
     */
    @Override
    public int getSellPrice() {
        return 20000;
    }

    /**
     * The item that can be exchanged
     * @return TheRemembranceOfGodric
     */
    @Override
    public Item getExchangeableItem() {
        return this;
    }

    /**
     * The weapon to be exchanged with
     * @param weaponName
     * @return A weapon in the HashMap
     */
    @Override
    public WeaponItem getExchangableWeapon(String weaponName) {
        return exchangeItem.get(weaponName);
    }

    /**
     * The item to exchange with
     * @return The HashMap
     */
    public HashMap<String, WeaponItem> getExchangeItem() {
        return exchangeItem;
    }
}
