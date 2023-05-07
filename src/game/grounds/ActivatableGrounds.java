package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;

public class ActivatableGrounds extends Ground implements Activatable{

    private boolean hasActivate = false;
    private String name;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public ActivatableGrounds(char displayChar) {
        super(displayChar);
    }



    public void setName(String name) {
        this.name = name;
    }

    /**
     * To check if the ground has been activated
     * @return True if its activated; false otherwise
     */
    public boolean isHasActivate() {
        return hasActivate;
    }

    public void setHasActivate(boolean hasActivate) {
        this.hasActivate = hasActivate;
    }

    /**
     *
     */
    @Override
    public void activate() {
        this.setHasActivate(true);
    }

    /**
     * @return
     */
    @Override
    public String getName() {
       return name;
    }
}
