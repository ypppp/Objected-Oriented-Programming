package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.HashMap;

public interface Exchangeable {
    Item getExchangeableItem();
    WeaponItem getExchangableWeapon(String weaponName);
    HashMap<String, WeaponItem> getExchangeItem();


}
