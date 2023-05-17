package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * The Enemy Factory that spawns enemies for the east side of the map. It implements the EnemyFactory.
 * @author Yew Yee Perng
 * @version 1.0
 */
public class EastEnemyFactory implements EnemyFactory{
    /**
     * Constructor.
     */
    public EastEnemyFactory() {

    }
    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a SkeletonBandit if the condition is met otherwise null.
     */
    @Override
    public Actor createSkeleton(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 27 && !location.containsAnActor()){
            return new SkeletonBandit();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a GiantCrayfish if the condition is met otherwise null.
     */
    @Override
    public Actor createCrustaceans(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 1 && !location.containsAnActor()){
            return new GiantCrayfish();
        }
        else{
            return null;
        }
    }

    /**
     * If the probability allows and the location has no actor, an enemy will be spawned on the spot.
     * @param location The location of where the enemy will spawn
     * @return returns a GiantDog if the condition is met otherwise null.
     */
    @Override
    public Actor createCanine(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 4 && !location.containsAnActor()){
            return new GiantDog();
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
        if(RandomNumberGenerator.getRandomInt(100)< 45 && !location.containsAnActor()){
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
        if(RandomNumberGenerator.getRandomInt(100)< 37 && !location.containsAnActor()){
            return new Dog();
        }
        else{
            return null;
        }
    }



}

