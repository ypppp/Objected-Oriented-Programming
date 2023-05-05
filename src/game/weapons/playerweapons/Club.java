package game.weapons.playerweapons;



import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.items.Purchasable;
import game.items.Sellable;

/**
 * The Wretch class's signature weapon which is purchasable and sellable
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tong Jet Kit
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




    @Override
    public void tick(Location currentLocation, Actor actor) {}

    /**
     * To get the purchase price of the weapon
     * @return An integer that is the purchase price of this weapon
     */
    @Override
    public int getPurchasePrice() {
        return 600;
    }

    /**
     * To return a newly instantiated purchasable weapon
     * @return A newly instantiated weapon which is itself
     */
    @Override
    public WeaponItem getPurchaseItem() {
       return new Club();
    }

    /**
     * To get the selling price of the weapon
     * @return An integer that is the selling price of this weapon
     */
    @Override
    public int getSellPrice() {
        return 100;
    }
}
