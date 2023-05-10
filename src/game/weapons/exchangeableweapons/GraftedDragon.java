package game.weapons.exchangeableweapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.items.Exchangeable;
import game.items.Sellable;

public class GraftedDragon extends WeaponItem implements Sellable{
    /**
     * Constructor.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "chomps", 90);
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
        return 200;
    }
}