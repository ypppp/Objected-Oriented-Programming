package game.weapons.enemyweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.action_types.SellWeaponAction;
import game.entity.players.Player;
import game.items.Sellable;


public class Grossmesser extends WeaponItem implements Sellable {


    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser",'?',115,"Slashes",85);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);
    }

    public Action getSkill(Actor holder){
        return new AOE_AttackAction(this);
    }


    /**
     *
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
