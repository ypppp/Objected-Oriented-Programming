package game.items.runes;

import edu.monash.fit2099.engine.items.Item;

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
}
