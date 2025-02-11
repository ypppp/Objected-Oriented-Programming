package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The ground that spawns the enemy
 * @author Tong Jet Kit
 * @see Ground
 * @version 1.0
 */
public abstract class SpawningGrounds extends Ground {

    /**
     * An enemy Factory to spawn an enemy
     */
    private EnemyFactory factory;

    /**
     * To determine if there is an enemy factor on this ground
     */
    private boolean hasFactory = false;

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
     * @param factory The factory that spawns enemy of the spawning ground
     */
    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }
    /**
     * To spawn the enemy at that current location
     * @param location The location of where the enemy will spawn
     */
    public abstract void spawn(Location location);

    /**
     * To allow the ground to experience the joy of time.
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if(!hasFactory){
            if(location.x()>=38){
                this.setFactory(new EastEnemyFactory());
                hasFactory = true;
            }
            else if (location.x() < 38){
                this.setFactory(new WestEnemyFactory());
                hasFactory = true;
            }
        }
        this.spawn(location);

    }
}

