package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.ActivateAction;
import game.action_types.RestAction;
import game.action_types.TravelAction;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A place for the player to rest
 * @author Aaren Wong
 * @see Ground
 * @version 1.0

*/
public class TheSiteOfLostGrace extends Ground implements Activatable, Travelable{

    /**
     * To check if the site of lost grace has been activated or not
     */
    private boolean hasActivate = false;

    /**
     * name of the site of lost grace
     */
    private String name;

    /**
     * A hashmap of site of lost grace - location key value pair
     */
    private static HashMap<TheSiteOfLostGrace,Location> fastTravel = new HashMap<>();

    /**
     * Constructor
     * @param name A string which represents the name of the site of lost grace
     */
    public TheSiteOfLostGrace(String name) {
        super('U');
        this.name = name;
    }
    /**
     * A getter to get the name of the site of lost grace
     * @return A string which is the name of the site of lost grace
     */
    public String getName() {
        return name;
    }

    /**
     * To set the name of the site of lost grace
     * @param name The name of the site of lost grace
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To allow the site of lost grace to experience the flow of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (isHasActivate()) {
            TheSiteOfLostGrace.addFastTravelSite(this, location);
        }
    }

    /**
     * To return the actions that the actor can be doing while on this ground
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of actions that the actor can be doing while on this ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // if the site has been activated
        if(isHasActivate()){
            for(TheSiteOfLostGrace activatedSiteLocation: fastTravel.keySet()){
                if(activatedSiteLocation != this){
                    actions.add(new TravelAction(activatedSiteLocation));
                }
            }
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

    /**
     * To add the newly activated site of lost grace which we can travel to into the static hashmap
     * @param site The activated Site Of Lost Grace
     * @param location The location of the Site of Lost Grace
     */
    public static void addFastTravelSite(TheSiteOfLostGrace site, Location location){
        fastTravel.put(site, location);
    }


    /**
     * To activate the site of lost grace
     */
    @Override
    public void activate() {
        this.setHasActivate(true);
    }

    /**
     * To check if the site of lost grace has been activated
     * @return True if its activated; false otherwise
     */
    public boolean isHasActivate() {
        return hasActivate;
    }

    /**
     * To set the site of lost grace to be active or not
     * @param hasActivate A boolean value which represents whether the site is active or not
     */
    public void setHasActivate(boolean hasActivate) {
        this.hasActivate = hasActivate;
    }


    /**
     * To get the destination of the fast travel
     * @return The location of the fast travel
     */
    @Override
    public Location getDestinationLocation() {
        return fastTravel.get(this);
    }

    /**
     * To print out the name of the site of lost grace when printing the object
     * @return A string which is the name of the site of lost grace
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * To travel to the location
     * @param actor The actor that is travelling
     * @param map The map where the actor is
     */
    @Override
    public void travel(Actor actor, GameMap map) {
        map.moveActor(actor,this.getDestinationLocation());
    }


}
