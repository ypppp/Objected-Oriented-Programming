package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.UnsheatheAction;

public class Uchigatana extends WeaponItem {



    /**
     * Constructor for Uchigatana weapon
     */
    public Uchigatana() {
        super("Uchigatana",'(',115,"slashes",80);
        this.addCapability(Status.HAS_SINGLE_ATTACK_ACTION);

    }


    /**
     * Constructor for Uchigatana in skill form
     * @param damage The damage done by the weapon
     * @param hitRate The chance for the weapon to hit
     */
    public Uchigatana(int damage, int hitRate) {
        super("Uchigatana", '(', damage, "slashes", hitRate);
        this.addCapability(Status.HAS_SINGLE_ATTACK_ACTION);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target,direction, new Uchigatana(230,60));
    }

    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM
}
