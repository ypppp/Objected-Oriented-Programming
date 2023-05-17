package game.entity.players;

import game.weapons.playerweapons.Staff;

/**
 * An astrologer role class that has a staff as its signature weapon
 * @author Aaren Wong
 * @version 1.0.0
 * @see Player
 */
public class Astrologer extends Player{
    /**
     * Constructor for an Astrologer class
     */
    public Astrologer() {
        super("Tarnished", '@', 396);
        this.addWeaponToInventory(new Staff());
    }
}
