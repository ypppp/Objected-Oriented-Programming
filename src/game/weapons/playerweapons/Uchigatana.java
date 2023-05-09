package game.weapons.playerweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.QuickStepAction;
import game.action_types.UnsheatheAction;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The signature weapon for the Samurai class which is sellable and purchasable
 * @author Tong Jet Kit
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 * @version 1.0
 */
public class Uchigatana extends WeaponItem implements Purchasable, Sellable {


    /**
     * Constructor for Uchigatana weapon
     */
    public Uchigatana() {
        super("Uchigatana",'(',115,"slashes",80);
        this.addCapability(Status.HAS_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);

    }

    /**
     * To get the skill of the weapon which is a targeted unsheathe attack
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @return The skill action of the weapon which is the QuickStepAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target,direction,this);
    }

    /**
     * To return the purchase price of the weapon
     * @return An integer which is the purchase price of the weapon
     */
    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    /**
     * To return a newly instantiated purchasable weapon
     * @return A newly instantiated weapon which is itself
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new Uchigatana();
    }

    /**
     * To return the selling price of the weapon
     * @return An integer which is the selling price of the weapon
     */
    @Override
    public int getSellPrice() {
        return 500;
    }



}
