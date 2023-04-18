package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.CapabilitySet;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.AttackAction;
import game.UnsheatheAction;

import java.util.Random;

public class Uchigatana extends WeaponItem {



    /**
     * Constructor for Uchigatana weapon
     */
    public Uchigatana() {
        super("Uchigatana",'(',115,"slashes",80);
        this.addCapability(Abilities.UNSHEATHE);

    }


    /**
     * Constructor for Uchigatana in skill form
     * @param damage The damage done by the weapon
     * @param hitRate The chance for the weapon to hit
     */
    public Uchigatana(int damage, int hitRate) {
        super("Uchigatana", '(', 230, "slashes", hitRate);
        this.addCapability(Abilities.UNSHEATHE);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        Action skillAction = new UnsheatheAction(target,direction, new Uchigatana(230,60));
        return skillAction;
    }

    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM
}
