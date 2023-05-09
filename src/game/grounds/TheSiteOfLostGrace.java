package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.ActivateAction;
import game.action_types.RestAction;

import java.util.ArrayList;

public class TheSiteOfLostGrace extends Ground implements Activatable{

    private boolean hasActivate = false;
    private String name;
    private static ArrayList<Location> fastTravelLocation = new ArrayList<Location>();


    public TheSiteOfLostGrace(String name) {
        super('U');
        this.setName(name);
    }

//    @Override
//    public void tick(Location location) {
//        if(isHasActivate()){
//            addFastTravelLocation();
//        }
//    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();


        // if the site has been activated
        if(isHasActivate()){
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                actions.add(new RestAction(this));
                return actions;
            }
            return actions;

        }
        else{
            actions.add(new ActivateAction(this));
        }
        return actions;


    }

    public static void addFastTravelLocation(Location location){
        fastTravelLocation.add(location);
    }

    /**
     *
     */
    @Override
    public void activate() {
        this.setHasActivate(true);
    }

    public boolean isHasActivate() {
        return hasActivate;
    }

    public void setHasActivate(boolean hasActivate) {
        this.hasActivate = hasActivate;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return name;
    }


}
