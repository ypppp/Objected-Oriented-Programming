package game.entity.enemies;


import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;

public class GiantCrab extends Enemy{
    /**
     * Constructor.
     */
    public GiantCrab() {
        super("GiantCrab", 'C',407);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.setSpeciesType(Species.CRUSTACEANS);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "pinches", 90);
    }
}
