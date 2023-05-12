package game.entity.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Status;
import game.action_types.reset.ResetManager;
import game.behaviours.LifestealBehaviour;
import game.grounds.GoldenFogDoor;

public class RegalAncestorSpirit extends Enemy{

    /**
     * Location of the hidden door in the boss room
     */
    private Location hiddenDoorLocation;

    /**
     * Location to the new location through using the door
     */
    private GoldenFogDoor hiddenDoor;
    /**
     * Constructor.
     */
    public RegalAncestorSpirit(Location hiddenDoorLocation, GoldenFogDoor hiddenDoor) {
        super("Regal Ancestor Spirit", 'Y', 1);
        this.addCapability(Status.BOSS);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.addBehaviour(1,new LifestealBehaviour());
        ResetManager.getInstance().removeResettable(this);
        this.hiddenDoorLocation = hiddenDoorLocation;
        this.hiddenDoor = hiddenDoor;
    }


    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(100,"charges",89);
    }

    @Override
    public boolean isConscious() {
        boolean status = super.isConscious();
        if(!status){
            hiddenDoorLocation.map().at(hiddenDoorLocation.x(),hiddenDoorLocation.y()).setGround(hiddenDoor);
        }
        return status;


    }
}
