package game.entity.enemies;


import java.util.HashMap;


public class PileOfBones extends Enemy{



    /**
     * Constructor.
     */
    public PileOfBones() {
        super("Pile of Bones", 'X',1);
        this.setBehaviours(new HashMap<>());


    }

}
