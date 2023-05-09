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

public class TheSiteOfLostGrace extends Ground implements Activatable, Travelable{

    private boolean hasActivate = false;
    private String name;
    private static HashMap<TheSiteOfLostGrace,Location> fastTravel = new HashMap<>();


    public TheSiteOfLostGrace(String name) {
        super('U');
        this.setName(name);
    }

    @Override
    public void tick(Location location) {
        if(isHasActivate()){
            TheSiteOfLostGrace.addFastTravelSite(this,location);
        }

    }

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

    public static void addFastTravelSite(TheSiteOfLostGrace site, Location location){
        fastTravel.put(site, location);
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
    public Location getDestinationLocation() {
        return fastTravel.get(this);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * @param actor
     * @param map
     */
    @Override
    public void travel(Actor actor, GameMap map) {
        map.moveActor(actor,this.getDestinationLocation());
    }


}
