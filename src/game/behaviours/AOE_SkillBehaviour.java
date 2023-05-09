package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
import game.Status;
import game.action_types.AOE_AttackAction;
import game.entity.enemies.Enemy;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The behaviour of the enemy to do an aoe skill action
 * @author Tong Jet Kit
 * @version 1.0
 * @see Behaviour
 */
public class AOE_SkillBehaviour implements Behaviour {

    /**
     * Obtain the action to be executed by this behaviour
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return An action to be executed
     */

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Actor> attackableList = AOE_AttackAction.getAllTargets(actor, map);
        if(!attackableList.isEmpty()){
            if (actor.hasCapability(Status.HAS_AOE_ATTACK_SKILL) && RandomNumberGenerator.getRandomInt(100) < 50){
                if(actor.getWeaponInventory().size()==0){
                    return new AOE_AttackAction(attackableList,actor.getIntrinsicWeapon());
                }
                else{
                    return new AOE_AttackAction(attackableList,actor.getWeaponInventory().get(0));
                }

            }
        }

        return null;
    }
}
