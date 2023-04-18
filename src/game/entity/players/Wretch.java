package game.entity.players;

import game.weapons.Club;

public class Wretch extends Player{
    /**
     * Constructor for a Wretch class
     */
    public Wretch() {
        super("Tarnished", '@', 300);
        this.addWeaponToInventory(new Club());
        this.setCombatClass(ClassType.WRETCH);
    }
}
