package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomNumberGenerator;
import game.entity.creep.Ally;
import game.entity.creep.Creep;
import game.entity.creep.Invader;
import game.entity.creep.SummonedManager;
import game.grounds.SummonSign;

public class SummonAction extends Action {
    private SummonSign summonSign;

    public SummonAction(SummonSign summonSign){
        this.summonSign = summonSign;
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
        if (RandomNumberGenerator.getRandomInt(0,100)<50){
//            spawn ally
            Ally ally = new Ally();
            Actor currentActor = 
            map.at().addActor(ally);
            SummonedManager.getInstance().registerCreep(ally);
        } else {
//            spawn invader
            Invader invader = new Invader();
            map.at().addActor(new Invader());
            SummonedManager.getInstance().registerCreep(invader);
        }
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
