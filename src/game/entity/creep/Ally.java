package game.entity.creep;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.RandomNumberGenerator;
import game.Species;
import game.Status;
import game.action_types.AttackAction;
import game.action_types.despawn.Despawnable;
import game.action_types.reset.Resettable;
import game.behaviours.FollowBehaviour;
import game.entity.players.Player;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Staff;
import game.weapons.playerweapons.Uchigatana;

/**
 * The Ally class that is spawned to assist the player
 * @author Yew Yee Perng
 * @version 1.0
 * @see Creep
 */

public class Ally extends Creep {



    /**
     * Constructor.
     *
     */
    public Ally() {
        super("Ally", 'A', 1 );
        setCharacter();
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Species.ALLY);

    }

    /**
     * To randomly select a character for the invader
     *
     */
    public void setCharacter() {

        int randomInt = RandomNumberGenerator.getRandomInt(100);

        if (randomInt < 25) {  // 0-24 = Astrologer is picked randomly
            this.hitPoints = 396;
            this.addWeaponToInventory(new Staff());
        } else if (randomInt < 50) { // 25-49 = Bandit is picked randomly
            this.hitPoints = 414;
            this.addWeaponToInventory(new GreatKnife());
        } else if (randomInt < 75) { // 50-74 = Samurai is picked randomly
            this.hitPoints = 455;
            this.addWeaponToInventory(new Uchigatana());
        } else {  // 75-99 = Wretch is picked randomly
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
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) { //unsure
        ActionList actions = new ActionList();
        //if this otherActor is a player
        if(otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            otherActor.addCapability(Status.IN_COMBAT);
            actions.add(new AttackAction(this, direction)); // add the intrinsic weapon attack

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
