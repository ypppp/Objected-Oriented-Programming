package game.items.runes;

import edu.monash.fit2099.engine.positions.Location;
import game.RandomNumberGenerator;
import game.action_types.reset.ResetManager;

import java.util.HashMap;

public class RuneManager {

    private static RuneManager runeManager = null;
    private Rune playerRune;
    private HashMap<Character, int[]> runeAmount;
    private Location playerLocation;
    private Location runeLocation;
    private Rune droppedRunes;

    public Rune getDroppedRunes() {
        return droppedRunes;
    }

    public void setDroppedRunes(Rune droppedRunes) {
        this.droppedRunes = droppedRunes;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public Location getRuneLocation() {
        return runeLocation;
    }

    public void setRuneLocation(Location runeLocation) {
        this.runeLocation = runeLocation;
    }

    public RuneManager() {
        this.playerRune = new Rune();
        runeAmount = new HashMap<>();
        runeAmount.put('X',new int[]{35,892});
        runeAmount.put('h',new int[]{55,1470});
        runeAmount.put('C',new int[]{318,4961});
        runeAmount.put('b',new int[]{35,892});
        runeAmount.put('G',new int[]{313,1808});
        runeAmount.put('R',new int[]{500,2374});
        ResetManager.getInstance().registerResettable(playerRune);
    }

    public static RuneManager getInstance(){
        if(runeManager == null){
            runeManager = new RuneManager();
        }

        return runeManager;
    }

    public boolean canMakePurchase(int amount){
        if(playerRune.getAmount()<amount){
            return false;
        }
        return true;
    }

    public String runesDroppedByEnemies(Character displayChar){
        int min = runeAmount.get(displayChar)[0];
        int max = runeAmount.get(displayChar)[1];
        int runesAmountDropped = RandomNumberGenerator.getRandomInt(min, max);
        addRunes(runesAmountDropped);
        return runesAmountDropped + " ";
    }

    public String removeRunes(int amount){
        playerRune.setAmount(playerRune.getAmount()-amount);
        return playerRune.getAmount() + " ";
    }

    public String addRunes(int amount){
        playerRune.setAmount(playerRune.getAmount()+amount);
        return playerRune.getAmount() + " ";
    }

    public Rune getRune() {
        return playerRune;
    }

}
