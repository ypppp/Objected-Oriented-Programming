package game.entity.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
import game.Status;
import game.action_types.AttackAction;
import game.action_types.despawn.DespawnAction;
import game.action_types.despawn.Despawnable;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.action_types.reset.ResetManager;
import game.action_types.reset.Resettable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * An enemy abstract class that contains all the attributes/methods of an enemy
 * @author Tong Jet Kit
 * @version 1.0
 * @see Actor
 * @see Despawnable
 * @see Resettable
 */
public abstract class Enemy extends Actor implements Despawnable, Resettable {

    /**
     * A hashmap of behaviours that is sorted against its priority which will be the key
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * A boolean value to determine if the enemy is following a player or not
     */
    private boolean isFollow = false;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addBehaviour(2, new AttackBehaviour());
        this.addBehaviour(999,new WanderBehaviour());
        ResetManager.getInstance().registerResettable(this);

    }

    /**
     * To add a behaviour into the hashmap of behaviours
     * @param key The priority of the behaviour
     * @param behaviour The behaviour
     */
    public void addBehaviour(int key, Behaviour behaviour){
        behaviours.put(key,behaviour);
    }

    /**
     * A getter to return the hashmap of behaviours
     * @return A hashmap which contains the behaviour which is sorted in priority
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }

    /**
     * A setter to set the hashmap of behaviours
     * @param behaviours The hashmap of behaviours
     */
    public void setBehaviours(Map<Integer, Behaviour> behaviours) {
        this.behaviours = behaviours;
    }

    /**
     * To despawn the enemy
     * @return An action to despawn the enemy
     */
    public Action despawn() { return new DespawnAction(); }

    /**
     * To reset the enemy
     */
    @Override
    public void reset() {
        this.addCapability(Status.RESET);
    }


    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // if the chance have been met, you are not following and you are not a boss or if you are resetting
        if (((RandomNumberGenerator.getRandomInt(100)<10) && !this.isFollow && !this.hasCapability(Status.BOSS)) || this.hasCapability(Status.RESET)){
                this.removeCapability(Status.RESET);
                ResetManager.getInstance().removeResettable(this);
                return despawn();
        }

        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
            }

        return new DoNothingAction();
    }



    /**
     * To return the actions that the otherActor can do to itself
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A list of action that the otherActor can do to you
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        //if this otherActor is a player
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){

            otherActor.addCapability(Status.IN_COMBAT);
            actions.add(new AttackAction(this, direction)); // add the intrinsic weapon attack
            this.addBehaviour(3,new FollowBehaviour(otherActor)); // let this enemy follow the player
            this.isFollow = true;

            // if the player has more than one weapon then add an AttackAction for each weapon
            if(otherActor.getWeaponInventory().size()!=0){
                for(WeaponItem weapon: otherActor.getWeaponInventory()){
                    if(weapon.hasCapability(Status.HAS_ATTACK_SKILL)){ // if this weapon got targeted skill then add the skill action
                        actions.add(weapon.getSkill(this,direction));
                    }
                    actions.add(new AttackAction(this,direction,weapon));
                }
            }


        }

        return actions;
    }

}
