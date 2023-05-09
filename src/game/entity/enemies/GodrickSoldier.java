package game.entity.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.playerweapons.Club;

public class GodrickSoldier extends Enemy{
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.COMPANION);
        this.addCapability(Status.CAN_DROP_RUNES);
        WeaponItem weapon = new Club();
        weapon.togglePortability();
        this.addWeaponToInventory(weapon);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches", 85);
    }
}
