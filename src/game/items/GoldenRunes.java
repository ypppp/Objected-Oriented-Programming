package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.NumberRange;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
//import game.action_types.PickUpGoldenRunesAction;
import game.Status;
import game.action_types.ConsumeAction;
import game.items.runes.RuneManager;

import java.util.List;
import java.util.Random;
/**
 * The GoldenRunes class which is a consumable item
 * @author Aaren Wong
 * @version 1.0.0
 * @see Item
 * @see Consumables
 */
public class GoldenRunes extends Item implements Consumables{
    /**
     * The number of uses of the item
     */
    private int uses = 1;
    /***
     * Constructor.
     */
    public GoldenRunes() {
        super("Golden Runes", '*', true);
    }

    /**
     * Remove the consume action
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        if (!getAllowableActions().isEmpty()) {
            removeAction(getAllowableActions().get(0));
        }
    }

    /**
     * Add consume action if allowed
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            if (getAllowableActions().isEmpty()){
                this.addAction(new ConsumeAction(this));
            }
        }
    }

    /**
     * To consume the rune
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
     * @return The number of uses left for the item
     */
    @Override
    public int getUses() {
        return uses;
    }

    /**
     * To set the number of uses for the item
     * @param uses The number of uses of this item
     */
    @Override
    public void setUses(int uses) {

    }

    /**
     * The total current amount of uses left for the item
     * @return The current amount of uses left for the item
     */
    @Override
    public String printNumberOfUses() {
        return "(" + uses + "/" + 1 + ")";
    }


}
