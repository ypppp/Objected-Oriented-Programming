package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.enemyweapons.Grossmesser;

import java.util.ArrayList;

/**
 * The heavy skeleton swordsman that spawns in the gust of winds
 * @author Tong Jet Kit
 * @version 1.0
 * @see Enemy
 */
public class HeavySkeletonSwordsman extends Enemy{
    /**
     * Constructor.
     */
    public HeavySkeletonSwordsman() {
        super("Heavy Skeletal Swordsman", 'q',153);
        this.addCapability(Species.BONE);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        WeaponItem weapon = new Grossmesser();
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
