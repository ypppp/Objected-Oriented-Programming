package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public interface Purchasable {
    int getPurchasePrice();

    WeaponItem getPurchaseItem();
}
