package game.entity.players;

import game.weapons.Uchigatana;

public class Samurai extends Player {
    /**
     * Constructor for a Samurai class
     */
    public Samurai() {
        super("Tarnished", '@', 300);
        this.addWeaponToInventory(new Uchigatana());
        this.setCombatClass(ClassType.SAMURAI);
    }


}
