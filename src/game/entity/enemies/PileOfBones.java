package game.entity.enemies;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Species;
import game.Status;

import java.util.ArrayList;
import java.util.HashMap;


public class PileOfBones extends Enemy{

    private int counter = 3;
    private Actor revivedEnemy;

    /**
     * Constructor.
     */
    public PileOfBones(Actor enemy) {
        super("Pile of Bones", 'X',1);
        this.setBehaviours(new HashMap<>());
        this.addCapability(Status.CAN_DROP_RUNES);
        this.addCapability(Species.BONE);
        this.revivedEnemy = enemy;


    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // if counter becomes 0 then revive to the revivedEnemy
        // by removing the actor on that location then adding the revivedEnemy.

        if(counter==0){
            Location here = map.locationOf(this);
            map.removeActor(this);
            map.addActor(revivedEnemy, here);
            display.println(this.revivedEnemy + " has been revived");
        }

        counter--;

        return new DoNothingAction();
    }


}
