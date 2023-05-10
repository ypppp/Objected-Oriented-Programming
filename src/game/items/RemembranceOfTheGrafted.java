package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.weapons.exchangeableweapons.AxeOfGodric;
import game.weapons.exchangeableweapons.GraftedDragon;

import java.util.HashMap;

public class RemembranceOfTheGrafted extends Item implements Sellable, Exchangeable{

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

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * To get the purchase price of the weapon
     * @return An integer that is the purchase price of this weapon
     */

    @Override
    public int getSellPrice() {
        return 20000;
    }



    @Override
    public Item getExchangeableItem() {
        return this;
    }

    @Override
    public WeaponItem getExchangableWeapon(String weaponName) {
        return exchangeItem.get(weaponName);
    }

    public HashMap<String, WeaponItem> getExchangeItem() {
        return exchangeItem;
    }
}
