package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.Status;
import game.entity.enemies.Dog;
import game.entity.enemies.LoneWolf;

public class SummonSign extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SummonSign(char displayChar) {
        super('=');
    }

    @Override
    public void tick(Location location) {
        if(location.containsAnActor()){
            Actor currentActor = location.getActor();
            if(currentActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                if(RandomNumberGenerator.getRandomInt(100)< 51){
                    location.addActor(new Dog());  // Dog is ally atm
                }
                else{
                    location.addActor(new LoneWolf()); // lonewolf is invader atm
                }
            }
        }
    }
}
