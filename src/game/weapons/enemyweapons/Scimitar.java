package game.weapons.enemyweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.items.Purchasable;
import game.items.Sellable;

public class Scimitar extends WeaponItem implements Purchasable, Sellable {
    public Scimitar() {
        super("Scimitar",'s',118,"Slashes",88);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);

    }

    public Action getSkill(Actor holder){
        return new AOE_AttackAction(this);
    }

    /**
     * @return
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /**
     * @return
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
