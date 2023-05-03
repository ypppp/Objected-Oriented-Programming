package game.entity.players;

import game.weapons.playerweapons.Club;

public class Wretch extends Player{
    /**
     * Constructor for a Wretch class
     */
    public Wretch() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new Club());
        this.setCombatClass(ClassType.WRETCH);
    }
}
