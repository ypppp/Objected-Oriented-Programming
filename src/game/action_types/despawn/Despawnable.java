package game.action_types.despawn;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A despawnable interface
 * @author Aaren Wong Cong Ming
 * @version 1.0.0
 *
 */
public interface Despawnable {
    /**
     * Applies the despawn to any despawnable entities
     * @return the despawn action
     */
    Action despawn ();
}
