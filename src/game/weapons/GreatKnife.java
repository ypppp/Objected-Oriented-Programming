package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.QuickStepAction;

public class GreatKnife extends WeaponItem {


    /**
     * Constructor for a Great Knife weapon
     */
    public GreatKnife() {
        super("Great Knife", '/',75, "stabs", 70);
        this.addCapability(Status.HAS_SINGLE_ATTACK_ACTION);
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target,direction, new GreatKnife());
    }

    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM
}
