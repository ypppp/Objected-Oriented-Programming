package game.entity.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Species;
import game.Status;
import game.weapons.enemyweapons.Grossmesser;
import game.weapons.enemyweapons.Scimitar;

import java.util.ArrayList;

public class SkeletonBandit extends Enemy{
    public SkeletonBandit() {
        super("Skeleton Bandit", 'b',184);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.BONE);
        WeaponItem weapon = new Scimitar();
        weapon.togglePortability();
        this.addWeaponToInventory(weapon);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches", 85);
    }

}