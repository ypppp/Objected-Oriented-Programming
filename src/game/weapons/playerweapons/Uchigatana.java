package game.weapons.playerweapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.QuickStepAction;
import game.action_types.UnsheatheAction;
import game.items.Purchasable;
import game.items.Sellable;

public class Uchigatana extends WeaponItem implements Purchasable, Sellable {



    /**
     * Constructor for Uchigatana weapon
     */
    public Uchigatana() {
        super("Uchigatana",'(',115,"slashes",80);
        this.addCapability(Status.HAS_ATTACK_SKILL);
        this.addCapability(Status.SELLABLE);

    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target,direction,this);
    }

    /**
     * @return
     */
    @Override
    public int getPurchasePrice() {
        return 5000;
    }

    /**
     * @return
     */
    @Override
    public WeaponItem getPurchaseItem() {
        return new Uchigatana();
    }

    /**
     * @return
     */
    @Override
    public int getSellPrice() {
        return 500;
    }


    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM
}
