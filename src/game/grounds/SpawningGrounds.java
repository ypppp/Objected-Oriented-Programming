package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A type of ground that can spawn enemies
 * @author Tong Jet Kit
 * @see Ground
 */
public abstract class SpawningGrounds extends Ground {

    /**
     * An enemy Factory to spawn an enemy
     */
    private EnemyFactory factory;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGrounds(char displayChar) {
        super(displayChar);
    }

    /**
     * A getter to return the enemy Factory
     * @return An enemy Factory
     */
    public EnemyFactory getFactory() {
        return factory;
    }

    /**
     * A setter to set the enemy factory of the spawning ground
     * @param factory
     */
    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }

    /**
     * An abstract method to spawn the enemy at the current location
     * @param location The location where the enemy will spawn
     */
    public abstract void spawn(Location location);
}
