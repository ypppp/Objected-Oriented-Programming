package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.creep.Ally;
import game.entity.creep.Creep;
import game.entity.creep.Invader;
import game.entity.creep.SummonedManager;
import game.grounds.SummonSign;
import game.grounds.Summonable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SummonAction extends Action {
    private Summonable summonable;

    public SummonAction(Summonable summonable){
        this.summonable = summonable;
    }
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        ArrayList<Location> summonSignExits = new ArrayList<>();
        Location location = summonable.getLocation();
        for (Exit exits : location.getExits()){
            Location destination = exits.getDestination();
            if (!destination.containsAnActor()) {
                summonSignExits.add(destination);
            }
        }
        if (summonSignExits.isEmpty()) {
            result += "Cannot summon";
        } else {
            if (RandomNumberGenerator.getRandomInt(0,100)<50){
    //            spawn ally
                Ally ally = new Ally();
                summonSignExits.get(RandomNumberGenerator.getRandomInt(summonSignExits.size())).addActor(ally);
                SummonedManager.getInstance().registerCreep(ally);
                result += "Spawned an " + ally;
            } else {
    //            spawn invader
                Invader invader = new Invader();
                summonSignExits.get(RandomNumberGenerator.getRandomInt(summonSignExits.size())).addActor(invader);
                SummonedManager.getInstance().registerCreep(invader);
                result += "Spawned an " + invader;
                }
            }
        return result;
        }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest";
    }
}
