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

public interface EnemyFactory {

    Actor createSkeleton(Location location);

    Actor createCrustaceans(Location location);

    Actor createCanine(Location location);

    Actor createGodrick(Location location);

    Actor createDog(Location location);



}


