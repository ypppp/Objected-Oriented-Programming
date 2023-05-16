package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.Status;
import game.action_types.ConsumeAction;
import game.action_types.reset.Resettable;

import java.util.List;

/**
 * The FlaskOfCrimsonTears class that is a unique item to the player
 * @author Aaren Wong
 * @see Item
 * @see Resettable
 * @see Consumables
 * @version 1.0.0
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumables {
    /**
     * The max uses of the item
     */
    private int maxUses = 2;
    /**
     * The number of uses of the item
     */
    private int uses = 2;
    /**
     * The amount healed by the item
     */
    private int healAmount = 250;

    public int getUses() {
        return uses;
    }

    /**
     * The setter for the number of uses of the item
     * @param uses An integer that represents the uses of the item
     */
    public void setUses(int uses) {
        this.uses = uses;
    }

    /**
     * The number of uses left for the item
     * @return The number of uses left for the item
     */
    public String printNumberOfUses() {
        return "(" + uses + "/" + maxUses + ")";
    }

    /**
     * The constructor for the FlaskOfCrimsonTears class
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", ' ', false);
        this.addCapability(Status.HEAL);
        this.addAction(new ConsumeAction(this));
    }

    /**
     * Sets the number of uses to the max uses when a reset happens
     */
    @Override
    public void reset() {
        this.setUses(maxUses);
    }

    /**
     * Consumes the flask
     * @return A description of consuming the flask
     */
    @Override
    public String consume(Actor actor) {
        String result = "";

        actor.heal(this.healAmount);
        result += actor + " consumed Flask of Crimson Tears" + this.printNumberOfUses() + " for " + this.healAmount + " hp";
        this.setUses(this.getUses()-1);

        return  result;
    }
}


