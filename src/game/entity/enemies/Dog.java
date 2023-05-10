package game.entity.enemies;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;

public class Dog extends Enemy{
    public Dog() {
        super("Dog", 'a', 104);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.COMPANION);
        this.addCapability(Status.CAN_DROP_RUNES);


    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(104, "bites", 93);
    }
}
