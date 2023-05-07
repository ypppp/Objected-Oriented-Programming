package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * The Consumables interface
 */
public interface Consumables {
    /**
     * The consume the item
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
    int getHealAmount();

    /**
     * To set the number of uses for the item
     * @param uses
     */
    void setUses(int uses);

    /**
     * The total current amount of uses left for the item
     * @return The curren amount of uses left for the item
     */
    String printNumberOfUses();
}
