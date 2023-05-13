package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;

import java.util.ArrayList;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tong Jet Kit
 *
 */
public class LoneWolf extends Enemy {

    /**
     * Constructor.
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.addCapability(Status.CAN_DROP_RUNES);
        this.addCapability(Species.CANINE);
    }

    /**
     * Creates and returns an intrinsic weapon.
     * @return A newly instantiated intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }





}
