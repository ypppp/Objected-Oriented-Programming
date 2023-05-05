package game.weapons.playerweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.QuickStepAction;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The signature weapon for the Bandit class which is sellable and purchasable
 * @author Tong Jet Kit
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 */
public class GreatKnife extends WeaponItem implements Purchasable, Sellable {


    /**
     * Constructor for a Great Knife weapon
     */
    public GreatKnife() {
        super("Great Knife", '/',75, "stabs", 70);
        this.addCapability(Status.HAS_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    /**
     * To get the skill of the weapon which is a targeted quickstep attack
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @return The skill action of the weapon which is the QuickStepAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target,direction, this);
    }


    /**
     * To return the purchase price of the weapon
     * @return An integer which is the purchase price of the weapon
     */
    @Override
    public int getPurchasePrice() {
        return 3500;
    }

    /**
     * To return a newly instantiated purchasable weapon
     * @return A newly instantiated weapon which is itself
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new GreatKnife();
    }

    /**
     * To return the selling price of the weapon
     * @return An integer which is the selling price of the weapon
     */
    @Override
    public int getSellPrice() {
        return 350;
    }
}
