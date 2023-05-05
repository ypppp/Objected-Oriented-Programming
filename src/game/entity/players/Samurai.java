package game.entity.players;

import game.weapons.playerweapons.Uchigatana;

/**
 * A Samurai role class that has an uchigatana as its signature weapon
 * @author Tong Jet Kit
 * @see Player
 */
public class Samurai extends Player {
    /**
     * Constructor for a Samurai class
     */
    public Samurai() {
        super("Tarnished", '@', 455);
        this.addWeaponToInventory(new Uchigatana());

    }


}
