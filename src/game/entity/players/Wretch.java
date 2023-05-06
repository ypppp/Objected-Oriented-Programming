package game.entity.players;

import game.weapons.playerweapons.Club;

/**
 * A Wretch role class that has a club as its signature weapon
 * @author Tong Jet Kit
 * @Version 1.0
 * @see Player
 */
public class Wretch extends Player{
    /**
     * Constructor for a Wretch class
     */
    public Wretch() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new Club());

    }
}
