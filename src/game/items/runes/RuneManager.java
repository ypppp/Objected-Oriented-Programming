package game.items.runes;

import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.action_types.reset.ResetManager;

import java.util.HashMap;

/**
 * A manager class to manage the runes and its operation
 * @author Tong Jet Kit
 * @version 1.0
 */
public class RuneManager {

    /**
     * A rune manager static attribute to make this a singleton instance
     */
    private static RuneManager runeManager = null;

    /**
     * The runes that belongs to the player
     */
    private Rune playerRune;

    /**
     * The hashmap of character integer array pair which holds the min and max rune that an enemy can give
     */
    private HashMap<Character, int[]> runeAmount;

    /**
     * The location of the previous Location of the Player to drop the runes
     */
    private Location previousLocation;

    /**
     * The rune location of the dropped runes on the map
     */
    private Location runeLocation;

    /**
     * The runes that is dropped on the map
     */
    private Rune droppedRunes;

    /**
     * A getter to get the dropped runes
     * @return The dropped runes
     */

    public Rune getDroppedRunes() {
        return droppedRunes;
    }

    /**
     * To set the dropped runes
     * @param droppedRunes The dropped runes
     */
    public void setDroppedRunes(Rune droppedRunes) {
        this.droppedRunes = droppedRunes;
    }

    /**
     * A getter to get the previous location of the player to drop the runes
     * @return The location where the runes should be dropped
     */
    public Location getPreviousLocation() {
        return previousLocation;
    }

    /**
     * To set the previous location of the player to drop the runes
     * @param previousLocation The previous location of the player
     */
    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    /**
     * A getter to get the location of the dropped rune
     * @return the location of the dropped rune
     */
    public Location getRuneLocation() {
        return runeLocation;
    }

    /**
     * To set the location of the dropped runes
     * @param runeLocation The location of the dropped runes
     */
    public void setRuneLocation(Location runeLocation) {
        this.runeLocation = runeLocation;
    }

    /**
     * Constructor
     */
    public RuneManager() {
        this.playerRune = new Rune();
        runeAmount = new HashMap<>();
        runeAmount.put('X',new int[]{35,892});
        runeAmount.put('h',new int[]{55,1470});
        runeAmount.put('C',new int[]{318,4961});
        runeAmount.put('b',new int[]{35,892});
        runeAmount.put('G',new int[]{313,1808});
        runeAmount.put('R',new int[]{500,2374});
        runeAmount.put('a', new int[]{52,1390});
        runeAmount.put('p', new int[]{38,70});
        runeAmount.put('ඞ', new int[]{1358,5578});
    }

    /**
     * To get the instance of the runeManager if there is already one created else create one and return it
     * @return A rune Manager instance
     */
    public static RuneManager getInstance(){
        if(runeManager == null){
            runeManager = new RuneManager();
        }

        return runeManager;
    }


    /**
     * To determine if the player can make a purchase according to its rune count
     * @param amount The amount of runes that the player is spending
     * @return True if the player can spend runes; false otherwise
     */
    public boolean canMakePurchase(int amount){
        if(playerRune.getAmount()<amount){
            return false;
        }
        return true;
    }

    /**
     * To get runes from the enemy and display a description of it
     * @param displayChar The enemy that will drop the runes
     * @return A description of how many runes that the enemy has drop
     */
    public String runesDroppedByEnemies(Character displayChar){
        int min = runeAmount.get(displayChar)[0];
        int max = runeAmount.get(displayChar)[1];
        int runesAmountDropped = RandomNumberGenerator.getRandomInt(min, max);
        addRunes(runesAmountDropped);
        return runesAmountDropped + " ";
    }

    /**
     * To remove the amount of runes from the player
     * @param amount The amount to be removed
     * @return A string that described the number of runes the player has
     */
    public String removeRunes(int amount){
        playerRune.setAmount(playerRune.getAmount()-amount);
        return playerRune.getAmount() + " ";
    }

    /**
     * To add an amount of runes to the player
     * @param amount The amount to be added
     * @return A string that described the number of runes the player has
     */
    public String addRunes(int amount){
        playerRune.setAmount(playerRune.getAmount()+amount);
        return playerRune.getAmount() + " ";
    }

    /**
     * To obtain the player's rune
     * @return The player's rune
     */
    public Rune getRune() {
        return playerRune;
    }

    /**
     * To drop the player runes once they are dead
     */
    public void dropRuneByDeath(){
        // if there is a rune on the map remove it
        if (getRuneLocation() != null){
            getRuneLocation().removeItem(runeManager.getDroppedRunes());
        }
        // create a new rune object to drop it on the ground
        Rune runes = new Rune();
        runes.setAmount(getRune().getAmount());
        setDroppedRunes(runes);
        getRune().setAmount(0);

        // drop the rune and save the location for it for future removal
        getPreviousLocation().addItem(runes); // drops the rune
        setRuneLocation(getPreviousLocation()); // saves the rune location
    }


}
