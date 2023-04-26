package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;
import game.action_types.AOE_AttackAction;

import java.util.ArrayList;

public class GiantCrab extends Enemy{
    /**
     * Constructor.
     */
    public GiantCrab() {
        super("GiantCrab", 'C',407);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.CRUSTACEANS);
        this.addCapability(Status.HAS_SKILL);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "pinches", 90);
    }

    @Override
    public Action getSkill(ArrayList<Actor> targets) {
        return new AOE_AttackAction(targets,getIntrinsicWeapon());
    }
}
