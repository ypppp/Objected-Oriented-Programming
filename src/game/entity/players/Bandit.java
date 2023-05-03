package game.entity.players;

import game.weapons.playerweapons.GreatKnife;

public class Bandit extends Player{
    /**
     * Constructor for a Bandit class
     */
    public Bandit() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new GreatKnife());
    }
}
