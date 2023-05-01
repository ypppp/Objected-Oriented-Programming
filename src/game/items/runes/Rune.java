package game.items.runes;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.action_types.ConsumeAction;
import game.action_types.RecoverRuneAction;

import java.util.List;

public class Rune extends Item {

    private int amount;

    /***
     * Constructor.
     */
    public Rune() {
        super("Rune", '$', false);
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = Math.max(amount,0);
    }

    @Override
    public List<Action> getAllowableActions() {
        ActionList actions = new ActionList();
        actions.add(new RecoverRuneAction(this));

        return actions.getUnmodifiableActionList();
    }
}
