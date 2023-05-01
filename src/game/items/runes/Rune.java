package game.items.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;

public class Rune extends Item {

    private int amount;


    /***
     * Constructor.
     */
    public Rune() {
        super("Rune", '$', true);
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = Math.max(amount,0);
    }


}
