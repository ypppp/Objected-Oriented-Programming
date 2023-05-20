package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.HashMap;

/**
 * The Exchangeable interface
 * @author Aaren Wong
 * @version 1.0.0
 */
public interface Exchangeable {
    /**
     * A HashMap containing the key and the weapon item to be exchanged with
     * @return the item to exchange
     */
    HashMap<String, WeaponItem> getExchangeItem();


}
