package game.items;

import edu.monash.fit2099.engine.actions.Action;

public interface Consumables {
    Action consume();

    int getUses();

    int getHealAmount();

    void setUses(int uses);

    String printNumberOfUses();
}
