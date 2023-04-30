package game.action_types;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.items.FlaskOfCrimsonTears;

import java.nio.file.StandardCopyOption;

public class ConsumeAction extends Action {

    private FlaskOfCrimsonTears flaskOfCrimsonTears;

    public ConsumeAction(FlaskOfCrimsonTears flaskOfCrimsonTears) {
        this.flaskOfCrimsonTears = flaskOfCrimsonTears;
    }

    /**
     * Perform the Action.
     *
     * @param player The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor player, GameMap map) {
        String result = "";

        if (flaskOfCrimsonTears.getUses()>0 && player.hasCapability(Status.HOSTILE_TO_ENEMY)){
            player.heal(flaskOfCrimsonTears.getHealAmount());
            result += player + " consumed Flask of Crimson Tears" + flaskOfCrimsonTears.printNumberOfUses() + " for " + flaskOfCrimsonTears.getHealAmount() + " hp";
            flaskOfCrimsonTears.setUses(flaskOfCrimsonTears.getUses()-1);
        } else {
            result += "Flask of Crimson Tears" + flaskOfCrimsonTears.printNumberOfUses() + " is empty";
        }

        return result;
    }

    /**
     * Returns a descriptive string
     *
     * @param player The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor player) {
        return player + " consumed Flask of Crimson Tears" + flaskOfCrimsonTears.printNumberOfUses();
    }
}
