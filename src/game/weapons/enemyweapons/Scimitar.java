package game.weapons.enemyweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The weapon for the SkeletonBandit which is sellable and purchasable
 * @author Tong Jet Kit, Yew Yee Perng
 * @see WeaponItem
 * @see Purchasable
 * @see Sellable
 * @Version 1.0
 */
public class Scimitar extends WeaponItem implements Purchasable, Sellable {
    public Scimitar() {
        super("Scimitar",'s',118,"Slashes",88);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);

    }

    /**
     * To get the skill of the scimitar which is an untargeted spinning attack action
     * @param holder The holder of the weapon
     * @return An aoe attack action
     */
    @Override
    public Action getSkill(Actor holder){
        return new AOE_AttackAction(this);
    }

    /**
     * To get the purchase price of the weapon
     * @return An integer which is the purchase price of the weapon
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /**
     * To return newly instantiated purchasable weapon
     * @return A newly instantiated weapon which is itself
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new Scimitar();
    }

    /**
     * @return
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
