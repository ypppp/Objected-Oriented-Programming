package game.action_types;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;


public class UnsheatheAction extends AttackAction {

    /**
     * Constructor for the unsheathe action skill for Uchigatana where the damage is doubled and has a 60% chance of hitting
     * @param target The target of the skill
     * @param direction The direction of the actor
     * @param weapon The weapon used to attack
     */
    public UnsheatheAction(Actor target, String direction, Weapon weapon) {
        super(target, direction, weapon);
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = getWeapon();
        Actor target = getTarget();


        if (!(getRand().nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage =  weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);

        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }

        return result;
    }

    @Override
    public String hotkey() {
        return "U";
    }

    public String menuDescription(Actor actor) {
        return actor + " unsheathes and attack " + getTarget() + " at " + getDirection() + " with " + getWeapon();
    }
}
