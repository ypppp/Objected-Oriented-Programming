package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import game.Status;
import game.action_types.ConsumeAction;
import game.action_types.reset.Resettable;

import java.util.List;

public class FlaskOfCrimsonTears extends Item implements Resettable, Consumables {

    private int maxUses = 2;
    private int uses = 2;
    private int healAmount = 250;

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
    }

    public int getUses() {
        return uses;
    }


    public void setUses(int uses) {
        this.uses = uses;
    }

    public String printNumberOfUses() {
        return "(" + uses + "/" + maxUses + ")";
    }

    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", ' ', false);
        this.addCapability(Status.HEAL);
        this.addAction(consume());
    }

    @Override
    public void reset() {
        this.setUses(maxUses);
        //System.out.println(this.getUses());
    }

    @Override
    public Action consume() {
        return new ConsumeAction(this);
    }
}


