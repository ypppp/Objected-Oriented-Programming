package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
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
     * @param factory
     */
    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }

    public void spawn(Location location){
        Actor enemy = getFactory().spawnEnemy(location, this.getDisplayChar());
        if(enemy != null){
            location.addActor(enemy);
        }
    }

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
