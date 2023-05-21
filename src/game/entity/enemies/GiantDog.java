package game.entity.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.behaviours.AOE_SkillBehaviour;

import java.util.ArrayList;

/**
 * The giant dog that spawns in the gust of winds
 * @author Yew Yee Perng
 * @version 1.0
 * @see Enemy
 */
public class GiantDog extends Enemy{

    /**
     * Constructor.
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(Species.CANINE);
        this.addCapability(Status.CAN_DROP_RUNES);
        this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addBehaviour(1, new AOE_SkillBehaviour());
    }

    /**
     * Creates and returns an intrinsic weapon.
     * @return A newly instantiated intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "slams", 90);
    }


}
