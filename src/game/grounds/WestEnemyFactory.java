package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * The Enemy Factory that spawns enemies for the west side of the map. It implements the EnemyFactory.
 * @author Yew Yee Perng
 * @version 1.0
 */
public class WestEnemyFactory implements EnemyFactory{

    /**
     * Constructor.
     */
    public WestEnemyFactory() {
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a Heavy Skeleton Swordsman if the condition is met otherwise null.
     */
    @Override
    public Actor createSkeleton(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 28 && !location.containsAnActor()){
            return new HeavySkeletonSwordsman();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a GiantCrab if the condition is met otherwise null.
     */
    @Override
    public Actor createCrustaceans(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 3 && !location.containsAnActor()){
            return new GiantCrab();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a LoneWolf if the condition is met otherwise null.
     */
    @Override
    public Actor createCanine(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 34 && !location.containsAnActor()){
            return new LoneWolf();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy Soldier will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a Godrick Soldier if the condition is met otherwise null.
     */
    @Override
    public Actor createGodrick(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 46 && !location.containsAnActor()){
            return new GodrickSoldier();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a Dog if the condition is met otherwise null.
     */
    @Override
    public Actor createDog(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 38 && !location.containsAnActor()){
            return new Dog();
        }
        else{
            return null;
        }
    }



}

