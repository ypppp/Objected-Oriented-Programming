package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class WestEnemyFactory extends EnemyFactory{


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

