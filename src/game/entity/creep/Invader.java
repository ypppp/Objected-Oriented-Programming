package game.entity.creep;

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
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Staff;
import game.weapons.playerweapons.Uchigatana;

/**
 * The Invader class that is spawned randomly as a character-liked enemy to the player
 * @author Yew Yee Perng
 * @version 1.0
 * @see Creep
 */

public class Invader extends Creep {

    /**
     * A boolean value to determine if the enemy is following a player or not
     */
    private boolean isFollow = false;

    /**
     * Constructor.
     *
     */
    public Invader() {
        super("Invader", 'ඞ', 1);
        setCharacter();
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addCapability(Species.INVADER);
        this.addCapability(Status.CAN_DROP_RUNES);
        this.isFollow = false;
    }

    /**
     * To randomly select a character for the invader
     *
     */
    public void setCharacter(){

        int randomInt = RandomNumberGenerator.getRandomInt(100);

        if (randomInt < 25){  // 0-24 = Astrologer is picked randomly
            this.hitPoints = 396;
            this.addWeaponToInventory(new Staff());
        }
        else if(randomInt < 50){ // 25-49 = Bandit is picked randomly
            this.hitPoints = 414;
            this.addWeaponToInventory(new GreatKnife());
        }
        else if(randomInt < 75){ // 50-74 = Samurai is picked randomly
            this.hitPoints = 455;
            this.addWeaponToInventory(new Uchigatana());
        }
        else{  // 75-99 = Wretch is picked randomly
            this.hitPoints = 414;
            this.addWeaponToInventory(new Club());
        }
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
