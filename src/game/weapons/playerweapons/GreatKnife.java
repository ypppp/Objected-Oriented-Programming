package game.weapons.playerweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.QuickStepAction;
import game.items.Purchasable;
import game.items.Sellable;

public class GreatKnife extends WeaponItem implements Purchasable, Sellable {


    /**
     * Constructor for a Great Knife weapon
     */
    public GreatKnife() {
        super("Great Knife", '/',75, "stabs", 70);
        this.addCapability(Status.HAS_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target,direction, this);
    }


    /**
     * @return
     */
    @Override
    public int getPurchasePrice() {
        return 3500;
    }

    /**
     * @return
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new GreatKnife();
    }

    /**
     * @return
     */
    @Override
    public int getSellPrice() {
        return 350;
    }
}
