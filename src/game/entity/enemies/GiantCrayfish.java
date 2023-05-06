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
 * The giant crab that spawns in the puddle of water
 * @author Yew Yee Perng
 * @Version 1.0
 * @see Enemy
 */

public class GiantCrayfish extends Enemy{

        /**
         * Constructor.
         */
        public GiantCrayfish() {
            super("GiantCrayFish", 'R',4803);
            this.addCapability(Status.HOSTILE_TO_PLAYER);
            this.addCapability(Species.CRUSTACEANS);
            this.addCapability(Status.CAN_DROP_RUNES);
            this.addCapability(Status.HAS_AOE_ATTACK_SKILL);
            this.addBehaviour(1, new AOE_SkillBehaviour());
        }

        @Override
        public IntrinsicWeapon getIntrinsicWeapon() {
            return new IntrinsicWeapon(527, "pinches", 100);
        }


}
