package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.runes.RuneManager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public abstract class EnemyFactory {

    private  Map<Character, Actor> enemyInstance;
    private  HashMap<Character,Integer> enemySpawnChance;


    public Map<Character, Actor> getEnemyInstance() {
        return enemyInstance;
    }

    public void setEnemyInstance(Map<Character, Actor> enemyInstance) {
        this.enemyInstance = enemyInstance;
    }

    public HashMap<Character, Integer> getEnemySpawnChance() {
        return enemySpawnChance;
    }

    public void setEnemySpawnChance(HashMap<Character, Integer> enemySpawnChance) {
        this.enemySpawnChance = enemySpawnChance;
    }


    public abstract Actor spawnEnemy(Location location, Character displayChar);



}
