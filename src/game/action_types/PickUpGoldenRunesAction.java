//package game.action_types;
//
//import edu.monash.fit2099.engine.actions.Action;
//import edu.monash.fit2099.engine.actors.Actor;
//import edu.monash.fit2099.engine.positions.GameMap;
//import game.Status;
//import game.items.GoldenRunes;
//import game.items.runes.RuneManager;
//
//public class PickUpGoldenRunesAction extends Action {
//    private GoldenRunes goldenRunes;
//    /**
//     * The constructor of the PickUpGoldenRunesAction class
//     * @param goldenRunes The rune object that is recovered
//     */
//    public PickUpGoldenRunesAction(GoldenRunes goldenRunes) {
//        this.goldenRunes = goldenRunes;
//    }
//
//    /**
//     * Perform the Action.
//     *
//     * @param actor The actor performing the action.
//     * @param map   The map the actor is on.
//     * @return a description of what happened that can be displayed to the user.
//     */
//    @Override
//    public String execute(Actor actor, GameMap map) {
//        String result = "";
//
//        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
//            result += actor + " picked up Golden Rune";
//            map.locationOf(actor).removeItem(goldenRunes);
//            RuneManager.getInstance().setRuneLocation(null);
//        }
//
//        return result;
//    }
//
//    /**
//     * Returns a descriptive string
//     *
//     * @param actor The actor performing the action.
//     * @return the text we put on the menu
//     */
//    @Override
//    public String menuDescription(Actor actor) {
//        return actor + " picks up Golden Rune";
//    }
//}
