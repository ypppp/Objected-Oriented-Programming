package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.enemyweapons.Grossmesser;

import java.util.ArrayList;


public class HeavySkeletonSwordsman extends Enemy{
    /**
     * Constructor.
     */
    public HeavySkeletonSwordsman() {
        super("Heavy Skeletal Swordsman", 'q',153);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.BONE);
        WeaponItem weapon = new Grossmesser();
        weapon.togglePortability();
        this.addWeaponToInventory(weapon);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches", 85);
    }

    @Override
    public Action getSkill(ArrayList<Actor> targets) {
        return null;
    }
}
