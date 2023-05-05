package game.weapons.enemyweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.action_types.SellWeaponAction;
import game.entity.players.Player;
import game.items.Sellable;

/**
 * The weapon for the HeavySkeletonSwordsman which is sellable
 * @author Tong Jet Kit
 * @see WeaponItem
 * @see Sellable
 */
public class Grossmesser extends WeaponItem implements Sellable {


    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser",'?',115,"Slashes",85);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    /**
     * To get the skill of the grossmesser which is an untargeted spinning attack action
     * @param holder The holder of the weapon
     * @return An aoe attack action
     */
    @Override
    public Action getSkill(Actor holder){
        return new AOE_AttackAction(this);
    }


    /**
     * To get the selling price of the grossmesser
     * @return An integer which is the selling price of the grossmesser
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
