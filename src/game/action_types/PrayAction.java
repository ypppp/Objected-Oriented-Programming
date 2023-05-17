package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RandomNumberGenerator;
import game.Status;
import game.items.RemembranceOfTheGrafted;
import game.items.runes.RuneManager;

/**
 * An action to pray to the Church of Irith to get a blessing or a curse
 *
 * @author Tong Jet Kit
 * @see Action
 * @version 1.0
 */
public class PrayAction extends Action {
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";

        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            int chance = RandomNumberGenerator.getRandomInt(100);
            if(bless_or_curse()){
                //player getting blessed
                // heal ~ 0 - 44
                // runes ~ 35 - 89
                // remembrance ~ 90 - 99
                if(chance<45){
                    int healAmount = RandomNumberGenerator.getRandomInt(10,51);
                    actor.heal(healAmount);
                    result += "Godrick the Grafted has heard your prayers and healed your wounds \n";
                    result += actor + " healed for " + healAmount;
                } else if (chance < 90) {
                    String runeAmount = RuneManager.getInstance().addRunes(RandomNumberGenerator.getRandomInt(500,1001));
                    result += "Godrick the Grafted has heard your prayers and blessed you with fortunes \n";
                    result += actor + " gains " + runeAmount + "runes";
                }
                else {
                    actor.addItemToInventory(new RemembranceOfTheGrafted());
                    result += "Godrick the Grafted has heard your prayers and blessed you with his arms \n";
                    result += actor +" obtains the Remembrance of the Grafted ";
                }
            }
            else{
                // player getting cursed
                // damage ~ 0 - 32
                // remove rune ~ 33 - 65
                // cursed ~ 66 - 98

                if(chance < 33){
                    int damageAmount = RandomNumberGenerator.getRandomInt(100,251);
                    actor.hurt(damageAmount);
                    result += "Godrick the Grafted has reject your prayers and smitten you \n";
                    result += actor + " got smitten for " + damageAmount;
                }
                else if(chance < 66){
                    int runeAmount = Math.min(RandomNumberGenerator.getRandomInt(500,1501),RuneManager.getInstance().getRune().getAmount());
                    RuneManager.getInstance().removeRunes(runeAmount);
                    result += "Godrick the Grafted has reject your prayers and cursed you with poverty \n";
                    result += actor + " loses " + runeAmount + " runes";
                }
                else{
                    actor.addCapability(Status.CURSED);
                    result += "Godrick the Grafted has reject your prayers and cursed you \n";
                    result += actor + " is now cursed";
                }
            }

        }

        return result;
    }

    /**
     * To determine if you are getting blessed or getting cursed
     * @return True if you are blessed, false if you are getting cursed
     */
    private boolean bless_or_curse() {
        return RandomNumberGenerator.getRandomInt(2) != 0;
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rings the bell";
    }

}
