package game.entity.creep;

import edu.monash.fit2099.engine.positions.GameMap;
import game.action_types.reset.Resettable;

import java.util.ArrayList;
import java.util.List;

public class SummonedManager {
    /**
     * A list of Creep entities
     */
    private List<Creep> creeps;

    /**
     * The SummonedManager class attribute
     */
    private static SummonedManager instance = null;

    /**
     * The private constructor of the ResetManager
     */
    private SummonedManager() {
        this.creeps = new ArrayList<>();
    }

    /**
     * Get an instance of the ResetManager class
     * @return ResetManager instance
     */
    public static SummonedManager getInstance(){
        if (instance == null){
            instance = new SummonedManager();
        }
        return instance;
    }

    /**
     * Add Creep entities
     * @param creep A Creep entity
     */
    public void registerCreep(Creep creep) {
        creeps.add(creep);
    }

    /**
     * Remove Creep entities
     * @param creep A creep entity
     */
    public void removeCreep(Creep creep) {
        creeps.remove(creep);
    }

    /**
     * Causes a reset for all the resettable entities
     */
    public void del(GameMap map) {
        for (Creep creep : this.creeps){
            map.removeActor(creep);
        }
    }



}
