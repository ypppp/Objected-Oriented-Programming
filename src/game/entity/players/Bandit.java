package game.entity.players;

import game.weapons.playerweapons.GreatKnife;

/**
 * A bandit role class that has a greatknife as its signature weapon
 * @author Tong Jet Kit
 * @Version 1.0
 * @see Player
 */
public class Bandit extends Player{
    /**
     * Constructor for a Bandit class
     */
    public Bandit() {
        super("Tarnished", '@', 414);
        this.addWeaponToInventory(new GreatKnife());
    }
}
