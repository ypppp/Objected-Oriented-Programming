package game.items.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import game.action_types.RecoverRuneAction;
import game.action_types.reset.Resettable;

import java.util.List;

/**
 * The currency of the game
 * @author Tong Jet Kit
 * @see Item
 */
public class Rune extends Item {

    /**
     * The amount of the runes
     */
    private int amount;

    /***
     * Constructor.
     */
    public Rune() {
        super("Rune", '$', false);
        this.amount = 0;
    }

    /**
     * To get the amount of runes
     * @return An integer which is the amount of runes
     */
    public int getAmount() {
        return amount;
    }

    /**
     * To set the amount of runes
     * @param amount The amount to be set
     */
    public void setAmount(int amount) {
        this.amount = Math.max(amount,0);
    }

    /**
     * To return the actions that the item can give to its owner
     * @return A list of actions that its owner can do to you
     */
    @Override
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new RecoverRuneAction(this));

        return actions.getUnmodifiableActionList();
    }

}
