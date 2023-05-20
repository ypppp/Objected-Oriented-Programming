package game.action_types.reset;

import game.Status;

/**
 * A resettable interface
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Aaren Wong
 *
 */
public interface Resettable {
    /**
     * Causes a reset for all the resettable entities
     */
    void reset(Status status);

}
