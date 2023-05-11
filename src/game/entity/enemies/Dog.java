package game.entity.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;

/**
 * The dog that spawns from cage
 * @author Yew Yee Perng
 * @version 1.0
 * @see Enemy
 */

public class Dog extends Enemy{
    /**
     * Constructor.
     */
    public Dog() {
        super("Dog", 'a', 104);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.COMPANION);
        this.addCapability(Status.CAN_DROP_RUNES);


    }
    /**
     * Creates and returns an intrinsic weapon.
     * @return A newly instantiated intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(104, "bites", 93);
    }
}
