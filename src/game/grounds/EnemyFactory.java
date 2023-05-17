package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.entity.enemies.Enemy;
import game.entity.enemies.SkeletonBandit;
import game.items.runes.RuneManager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * The EnemyFactory interface
 * @author Yew Yee Perng
 * @version 1.0
 */
public interface EnemyFactory {

    /**
     * To create skeleton species enemies
     * @param location The location of where the enemy will spawn
     * @return A Skeleton species object added to the location in the map
     */
    Actor createSkeleton(Location location);

    /**
     * To create Crustaceans species enemies
     * @param location The location of where the enemy will spawn
     * @return A Crustacean species object added to the location in the map
     */
    Actor createCrustaceans(Location location);

    /**
     * To create Canine species enemies
     * @param location The location of where the enemy will spawn
     * @return A Canine species object added to the location in the map
     */
    Actor createCanine(Location location);

    /**
     * To create Godrick Soldiers
     * @param location The location of where the enemy will spawn
     * @return A Godrick soldier added to the location in the map
     */
    Actor createGodrick(Location location);

    /**
     * To create Dogs
     * @param location The location of where the enemy will spawn
     * @return A Dog added to the location in the map
     */
    Actor createDog(Location location);



}


