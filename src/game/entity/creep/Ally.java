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
import game.entity.players.Player;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Staff;
import game.weapons.playerweapons.Uchigatana;

public class Ally extends Creep {

    private final int randomInt = RandomNumberGenerator.getRandomInt(100);

    private int hp;

    private WeaponItem weapon;


    /**
     * Constructor.
     *
     */
    public Ally() {
        super("Ally", 'a', 0 );
        this.hitPoints = hp;
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Species.ALLY);
        this.addWeaponToInventory(weapon);
    }

    public void setCharacter(int randomInt){

        if (randomInt < 25){  // 0-24 = Astrologer is picked randomly
            hp = 396;
            weapon = new Staff();
        }
        else if(randomInt < 50){ // 25-49 = Bandit is picked randomly
            hp = 414;
            weapon = new GreatKnife();
        }
        else if(randomInt < 75){ // 50-74 = Samurai is picked randomly
            hp = 455;
            weapon = new Uchigatana();
        }
        else{  // 75-99 = Wretch is picked randomly
            hp = 414;
            weapon = new Club();
        }
    }


}
