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
public class WestEnemyFactory extends EnemyFactory{

    /**
     * Constructor for the enemy factory
     */
    public WestEnemyFactory() {
        HashMap<Character,Actor> enemyInstance = new HashMap<>(){{
            put('n', new HeavySkeletonSwordsman());
            put('&', new LoneWolf());
            put('~', new GiantCrab());
        }};
        HashMap<Character, Integer> enemySpawnChance = new HashMap<>(){{
            put('n',27);
            put('&',33);
            put('~',2);
        }};

        this.setEnemySpawnChance(enemySpawnChance);
        this.setEnemyInstance(enemyInstance);
    }

    /**
     * To return an enemy to be spawned at a certain location at west
     * @param location The location where the enemy will be spawning
     * @param displayChar The display character of the ground
     * @return An actor which will the enemy to be spawned on the location if granted; null otherwise
     */
    public Actor spawnEnemy(Location location, Character displayChar){
        try {
            Actor actorToAdd = getEnemyInstance().get(displayChar);
            Class<?> cls = actorToAdd.getClass();
            Constructor<?> constructor;
            constructor = cls.getConstructor();
            int spawnChance = getEnemySpawnChance().get(displayChar);

            if(RandomNumberGenerator.getRandomInt(100)< spawnChance && !location.containsAnActor()){
                return (Actor) constructor.newInstance();
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

