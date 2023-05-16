package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Consumables interface
 * @author Aaren Wong
 * @version 1.0
 */
public interface Consumables {
    /**
     * The consume the item
     * @param actor The actor that is consuming this item
     * @return The description of the consumption
     */
    String consume(Actor actor);

    /**
     * The number of uses left for the item
     * @return The number of uses left for the item
     */
    int getUses();

    /**
     * The amount healed by the item
     * @return The amount to heal
     */
    void setUses(int uses);

    /**
     * The total current amount of uses left for the item
     * @return The current amount of uses left for the item
     */
    String printNumberOfUses();
}
