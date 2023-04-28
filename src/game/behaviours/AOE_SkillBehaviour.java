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

public class AOE_SkillBehaviour implements Behaviour {
    /**
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return An action that the Actor can do
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
