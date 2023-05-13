package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.entity.enemies.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class WestEnemyFactory implements EnemyFactory{


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

    @Override
    public Actor createGodrick(Location location) {
        if(RandomNumberGenerator.getRandomInt(100)< 46 && !location.containsAnActor()){
            return new GodrickSoldier();
        }
        else{
            return null;
        }
    }

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

