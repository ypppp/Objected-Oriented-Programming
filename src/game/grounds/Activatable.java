package game.grounds;

/**
 * An interface for an object that is activatable
 * @author Tong Jet Kit
 * @version 1.0
 */
public interface Activatable {

    /**
     * To activate the object
     */
    void activate();

    /**
     * The toString method for an activatable object to get the description of the object
     * @return A string which represents the description of an activatable object
     */
    String toString();
}
