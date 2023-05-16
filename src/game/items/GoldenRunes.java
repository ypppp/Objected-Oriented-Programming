package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import game.RandomNumberGenerator;
//import game.action_types.PickUpGoldenRunesAction;
import game.Status;
import game.action_types.ConsumeAction;
import game.items.runes.RuneManager;

import java.util.List;
import java.util.Random;

public class GoldenRunes extends Item implements Consumables{
    private int uses = 1;
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    @Override
    public void tick(Location currentLocation) {
        if (!getAllowableActions().isEmpty()) {
            removeAction(getAllowableActions().get(0));
        }
    }


    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            if (getAllowableActions().isEmpty()){
                this.addAction(new ConsumeAction(this));
            }
        }
    }

    /**
     * The consume the item
     *
     * @param actor The actor that is consuming this item
     * @return The description of the consumption
     */
    @Override
    public String consume(Actor actor) {
        String result = "";

        int amount = RandomNumberGenerator.getRandomInt(200, 10000);
        RuneManager.getInstance().addRunes(amount);
        result += actor + " consumed Golden Rune" + this.printNumberOfUses() + " and receives " + amount + " runes";
        actor.removeItemFromInventory(this);

        return result;
    }

    /**
     * The number of uses left for the item
     *
     * @return The number of uses left for the item
     */
    @Override
    public int getUses() {
        return uses;
    }

    /**
     * To set the number of uses for the item
     *
     * @param uses The number of uses of this item
     */
    @Override
    public void setUses(int uses) {

    }

    /**
     * The total current amount of uses left for the item
     *
     * @return The current amount of uses left for the item
     */
    @Override
    public String printNumberOfUses() {
        return "(" + uses + "/" + 1 + ")";
    }


}
