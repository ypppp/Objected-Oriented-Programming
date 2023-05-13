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
 * An enemy factory to spawn an enemy at the east
 * @author Tong Jet Kit
 * @Version 1.0
 * @see EnemyFactory
 */
public class EastEnemyFactory implements EnemyFactory{

    /**
     * Constructor for the enemy factory
     */
    public EastEnemyFactory() {

    }

    @Override
    public Actor createSkeleton(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 28 && !location.containsAnActor()){
            return new SkeletonBandit();
        }
        else{
            return null;
        }
    }

    @Override
    public Actor createCrustaceans(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 2 && !location.containsAnActor()){
            return new GiantCrayfish();
        }
        else{
            return null;
        }
    }

    @Override
    public Actor createCanine(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 5 && !location.containsAnActor()){
            return new GiantDog();
        }
        else{
            return null;
        }
    }

}

