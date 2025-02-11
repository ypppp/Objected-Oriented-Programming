package game.action_types.reset;

import edu.monash.fit2099.engine.positions.Location;
import game.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Aaren Wong
 *
 */
public class ResetManager{
    /**
     * A list of resettable entities
     */
    private ArrayList<Resettable> resettables;
    /**
     * The ResetMamanger class attribute
     */
    private static ResetManager instance = null;
    /**
     * The spawn point location of the player
     */
    private Location spawnPoint;

    /**
     * The private constructor of the ResetManager
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Get an instance of the ResetManager class
     * @return ResetManager instance
     */
    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * The getter for the spawn point location of the player
     * @return The spawn point location of the player
     */
    public Location getSpawnPoint() {
        return spawnPoint;
    }

    /**
     * The setter for the spawn point location of the player
     * @param spawnPoint The location of the player's spawnpoint
     */
    public void setSpawnPoint(Location spawnPoint) {
        this.spawnPoint = spawnPoint;
    }

    /**
     * Causes a reset for all the resettable entities
     * @param status The reset status (player resting or player died)
     */
    public void run(Status status) {
            for (Resettable resettable : this.resettables){
                resettable.reset(status);
        }

    }

    /**
     * Add resettable entities
     * @param resettable A resettable entity
     */
    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    /**
     * Remove resettable entities
     * @param resettable A resettable entity
     */
    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }

}
