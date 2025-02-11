package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.action_types.reset.ResetManager;
import game.entity.creep.Ally;
import game.entity.creep.Invader;
import game.grounds.Summonable;

import java.util.ArrayList;

/**
 * The SummonAction class which handles what happens when it is called
 * @author Aaren Wong
 * @version 1.0.0
 * @see Action
 */
public class SummonAction extends Action {
    /**
     * A private instance of the Summonable class
     */
    private Summonable summonable;

    /**
     * Constructor.
     * @param summonable A summonable ground
     */
    public SummonAction(Summonable summonable){
        this.summonable = summonable;
    }
    /**
     * Perform the SummonAction which summons an ally or invader by chance at an empty spot around the summon sign if there is one
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
                summonable.summon(summonSignExits.get(RandomNumberGenerator.getRandomInt(summonSignExits.size())), ally);
                ResetManager.getInstance().registerResettable(ally);
                result += "Spawned an " + ally;
            } else {
    //            spawn invader
                Invader invader = new Invader();
                summonable.summon(summonSignExits.get(RandomNumberGenerator.getRandomInt(summonSignExits.size())), invader);
                ResetManager.getInstance().registerResettable(invader);
                result += "Spawned an " + invader;
                }
            }
        return result;
        }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " summons a guest";
    }
}
