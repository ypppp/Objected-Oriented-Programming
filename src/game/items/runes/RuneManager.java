package game.items.runes;

public class RuneManager {

    private static RuneManager runeManager = null;
    private Rune rune;

    public RuneManager() {
        this.rune = new Rune();
    }

    public static RuneManager getInstance(){
        if(runeManager == null){
            runeManager = new RuneManager();
        }

        return runeManager;
    }

    public boolean canMakePurchase(int amount){
        if(rune.getAmount()<amount){
            return false;
        }
        return  true;
    }

    public void removeRunes(int amount){
        rune.setAmount(rune.getAmount()-amount);
    }

    public void addRunes(int amount){
        rune.setAmount(rune.getAmount()+amount);
    }
}
