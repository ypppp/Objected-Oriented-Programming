package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * An interface for items that are purchasable
 * @Version 1.0
 * @author Tong Jet Kit
 */
public interface Purchasable {
    /**
     * To get the purchase price if the item
     * @return An integer that is the purchase price of the item
     */
    int getPurchasePrice();

    /**
     * To return a newly instantiated purchasable weapon
     * @return a newly instantiated purchasable weapon
     */
    WeaponItem getPurchaseItem();
}
