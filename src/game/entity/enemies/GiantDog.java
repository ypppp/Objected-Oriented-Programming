package game.entity.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.behaviours.AOE_SkillBehaviour;

import java.util.ArrayList;

public class GiantDog extends Enemy{
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.CANINE);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addBehaviour(1, new AOE_SkillBehaviour());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }

    @Override
    public Action getSkill(ArrayList<Actor> targets) {
        return new AOE_AttackAction(targets,getIntrinsicWeapon());
    }
}
