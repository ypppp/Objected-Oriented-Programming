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
 * An enemy factory to spawn an enemy at the west
 * @author Tong Jet Kit
 * @see EnemyFactory
 * @Version 1.0
 */
public class WestEnemyFactory implements EnemyFactory{

    /**
     * Constructor for the enemy factory
     */
    public WestEnemyFactory() {
    }

    @Override
    public Actor createSkeleton(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 28 && !location.containsAnActor()){
            return new HeavySkeletonSwordsman();
        }
        else{
            return null;
        }
    }

    @Override
    public Actor createCrustaceans(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 3 && !location.containsAnActor()){
            return new GiantCrab();
        }
        else{
            return null;
        }
    }

    @Override
    public Actor createCanine(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 34 && !location.containsAnActor()){
            return new LoneWolf();
        }
        else{
            return null;
        }
    }



}

