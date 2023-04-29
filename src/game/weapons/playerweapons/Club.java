package game.weapons.playerweapons;



import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem implements Purchasable, Sellable {


    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        this.addCapability(Status.SELLABLE);
    }


    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * @return An integer that is the purchase price of this weapon
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /**
     * @return A weapon which is itself
     */
    @Override
    public WeaponItem getPurchaseItem() {
       return this;
    }

    /**
     * @return An integer that is the selling price of this weapon
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
