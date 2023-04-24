package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 * @author Aaren Wong Cong Ming
 * Modified by:
 *
 */

public interface Despawnable {
    Action despawn ();
}
