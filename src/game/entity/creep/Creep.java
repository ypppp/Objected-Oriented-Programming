package game.entity.creep;

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
import game.action_types.reset.ResetManager;
import game.action_types.reset.Resettable;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Staff;
import game.weapons.playerweapons.Uchigatana;

import java.util.HashMap;
import java.util.Map;

public abstract class Creep extends Actor implements Despawnable, Resettable {
    /**
     * A hashmap of behaviours that is sorted against its priority which will be the key
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();


    /**
     * A boolean value to determine if the enemy is following a player or not
     */
    private boolean isFollow = false;

    public Creep(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addBehaviour(2, new AttackBehaviour());
        this.addBehaviour(999,new WanderBehaviour());
        ResetManager.getInstance().registerResettable(this);
        SummonedManager.getInstance().registerCreep(this);

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


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(this.hasCapability(Status.RESET)){
            this.removeCapability(Status.RESET);
            SummonedManager.getInstance().removeCreep(this);
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
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) || this.hasCapability(Status.HOSTILE_TO_PLAYER)){

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
