package game.entity.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.playerweapons.Club;

/**
 * The Godrick Soldier that spawns from Barrack
 * @author Yew Yee Perng
 * @version 1.0
 * @see Enemy
 */
public class GodrickSoldier extends Enemy{
    /**
     * Constructor.
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.addCapability(Species.COMPANION);
        this.addCapability(Status.CAN_DROP_RUNES);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        WeaponItem weapon = new Club();
        weapon.togglePortability();
        this.addWeaponToInventory(weapon);
    }
    /**
     * Creates and returns an intrinsic weapon.
     * @return A newly instantiated intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches", 85);
    }
}
