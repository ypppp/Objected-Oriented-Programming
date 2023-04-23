package game.entity.enemies;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;
import game.weapons.enemyweapons.Grossmesser;


public class HeavySkeletonSwordsman extends Enemy{
    /**
     * Constructor.
     */
    public HeavySkeletonSwordsman() {
        super("Heavy Skeletal Swordsman", 'q',153);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.setSpeciesType(Species.BONE);
        this.addWeaponToInventory(new Grossmesser());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(80, "punches", 85);
    }
}
