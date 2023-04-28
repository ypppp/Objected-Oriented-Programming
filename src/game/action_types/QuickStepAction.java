package game.action_types;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.DeathAction;

import java.util.List;
import java.util.Random;

public class QuickStepAction extends AttackAction {
    public QuickStepAction(Actor target, String direction, Weapon weapon) {
        super(target, direction, weapon);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Weapon weapon = getWeapon();
        Actor target = getTarget();
        Random rand = getRand();

        if (!(getRand().nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        Location currentLocation = map.locationOf(actor);
        List<Exit> exits = currentLocation.getExits();

        int damage =  weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);

        if(!exits.isEmpty()){
            Exit exit = exits.get(rand.nextInt(exits.size()));
            Location move = exit.getDestination();
            result += new MoveActorAction(move,exit.getName()).execute(actor,map);
        }

        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }



        return result;
    }

    public String menuDescription(Actor actor) {
        return actor + " attacks " + getTarget() + " at " + getDirection() + " with " + getWeapon();
    }

    @Override
    public String hotkey() {
        return "Q";
    }
}
