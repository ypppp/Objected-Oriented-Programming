package game.entity.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
import game.Species;
import game.Status;
import game.action_types.AttackAction;
import game.action_types.DespawnAction;
import game.action_types.Despawnable;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.entity.players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor implements Despawnable{

    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    private Species speciesType;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addBehaviour(999,new WanderBehaviour());
        this.addBehaviour(1, new AttackBehaviour());
    }

    public void addBehaviour(int key, Behaviour behaviour){
        behaviours.put(key,behaviour);
    }

    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }

    public void setBehaviours(Map<Integer, Behaviour> behaviours) {
        this.behaviours = behaviours;
    }

    public Species getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(Species speciesType) {
        this.speciesType = speciesType;
    }

    public Action despawn(){return new DespawnAction();}

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
        if (RandomNumberGenerator.getRandomInt(100)<10){
            return despawn();
        }
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
            }

        return new DoNothingAction();
    }

    public abstract Action getSkill(ArrayList<Actor> targets);

    /**
     * The lone wolf can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
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

            ((Player)otherActor).setInCombat(true);
            actions.add(new AttackAction(this, direction)); // add the intrinsic weapon attack
            this.addBehaviour(2,new FollowBehaviour(otherActor)); // let this enemy follow the player

            // if the player has more than one weapon then add an AttackAction for each weapon
            if(otherActor.getWeaponInventory().size()!=0){
                for(WeaponItem weapon: otherActor.getWeaponInventory()){
                    if(weapon.hasCapability(Status.HAS_ATTACK_SKILL)){ // if this weapon got skill then add the skill action
                        actions.add(weapon.getSkill(this,direction));
                    }
                    actions.add(new AttackAction(this,direction,weapon));
                }
            }


        }

        return actions;
    }
}
