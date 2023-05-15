package game.weapons.playerweapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The Astrologer class's signature weapon which is purchasable and sellable
 * @author Aaren Wong
 * @version 1.0.0
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class Staff extends WeaponItem implements Purchasable, Sellable {
    /**
     * Constructor.
     */
    public Staff() {
        super("Astrologer's Staff", 'f', 274, "smacks", 50);
        this.addCapability(Status.SELLABLE);
    }

    /**
     * To get the purchase price of the staff
     *
     * @return An integer that is the purchase price of the staff
     */
    @Override
    public int getPurchasePrice() {
        return 800;
    }

    /**
     * To return a newly instantiated staff
     *
     * @return a newly instantiated staff
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new Staff();
    }

    /**
     * To return the selling price of the staff
     *
     * @return An integer which is the selling price of the staff
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
