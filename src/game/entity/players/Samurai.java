package game.entity.players;

import game.weapons.playerweapons.Uchigatana;

public class Samurai extends Player {
    /**
     * Constructor for a Samurai class
     */
    public Samurai() {
        super("Tarnished", '@', 445);
        this.addWeaponToInventory(new Uchigatana());

    }


}
