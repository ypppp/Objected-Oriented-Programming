package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Species;
import game.Status;

import java.util.ArrayList;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Enemy {

    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.CANINE);
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }



    //    /**
//     * At each turn, select a valid action to perform.
//     *
//     * @param actions    collection of possible Actions for this Actor
//     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
//     * @param map        the map containing the Actor
//     * @param display    the I/O object to which messages may be written
//     * @return the valid action that can be performed in that iteration or null if no valid action is found
//     */
//    @Override
//    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
//        for (Behaviour behaviour : getBehaviours().values()) {
//            Action action = behaviour.getAction(this, map);
//            if(action != null)
//                return action;
//        }
//        return new DoNothingAction();
//    }
//
//    /**
//     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
//     *
//     * @param otherActor the Actor that might be performing attack
//     * @param direction  String representing the direction of the other Actor
//     * @param map        current GameMap
//     * @return
//     */
//    @Override
//    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
//        ActionList actions = super.allowableActions(otherActor, direction, map);
//        return actions;
//    }


}
