package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public abstract class SpawningGrounds extends Ground {

    private EnemyFactory factory;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SpawningGrounds(char displayChar) {
        super(displayChar);
    }

    public EnemyFactory getFactory() {
        return factory;
    }

    public void setFactory(EnemyFactory factory) {
        this.factory = factory;
    }

    public abstract void spawn(Location location);
}
