package game.weapons.playerweapons;



import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem {


    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        this.addCapability(Status.SELLABLE);
        this.addCapability(Status.PURCHASABLE);
    }


    // WEAPON HAS GETSKILL THAT CAN RETURN THE ATTACK ACTION IN SKILL FORM

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
