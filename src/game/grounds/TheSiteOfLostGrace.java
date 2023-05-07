package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.action_types.ActivateAction;
import game.action_types.RestAction;

public class TheSiteOfLostGrace extends ActivatableGrounds{


    public TheSiteOfLostGrace(String name) {
        super('U');
        this.setName(name);
    }


    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        // if the site has been activated
        if(isHasActivate()){
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY) && location.map().locationOf(actor) == location){
                actions.add(new RestAction(this));
                return actions;
            }
            for (Exit exit : location.getExits()){
                Location destination = exit.getDestination();
                if (destination.containsAnActor()) {
                    Actor destinationActor = destination.getActor();
                    if (destinationActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                        actions.add(new RestAction(this));
                    }
                }

            }

        }
        else{
            actions.add(new ActivateAction(this));
        }
        return actions;


    }

}
