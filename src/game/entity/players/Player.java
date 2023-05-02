package game.entity.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.FancyMessage;
import game.action_types.DeathAction;
import game.items.FlaskOfCrimsonTears;
import game.action_types.reset.ResetAction;
import game.action_types.reset.ResetManager;
import game.action_types.reset.Resettable;
import game.Status;

import game.items.runes.RuneManager;


/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public abstract class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();
	private ClassType combatClass;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		FlaskOfCrimsonTears flaskOfCrimsonTears = new FlaskOfCrimsonTears();
		this.addItemToInventory(flaskOfCrimsonTears);
		ResetManager.getInstance().registerResettable(flaskOfCrimsonTears);
		ResetManager.getInstance().registerResettable(this);

	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if (!this.isConscious()){
			for (String line : FancyMessage.YOU_DIED.split("\n")) { // display "YOU DIED"
				new Display().println(line);
				try {
					Thread.sleep(200);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			return new DeathAction(this);
		}
		RuneManager.getInstance().setPreviousLocation(map.locationOf(this));
		// Handle multi-turn Actions
		if(this.hasCapability(Status.IN_COMBAT)){
			for(WeaponItem weapon: this.getWeaponInventory()){
				if(weapon.hasCapability(Status.HAS_AOE_ATTACK_SKILL)){
					actions.add(weapon.getSkill(this));
				}
			}
		}

		this.removeCapability(Status.IN_COMBAT);

		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		display.println(this + this.printHp() + ", runes:" + RuneManager.getInstance().getRune().getAmount());

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	public ClassType getCombatClass() {
		return combatClass;
	}

	public void setCombatClass(ClassType combatClass) {
		this.combatClass = combatClass;
	}

	@Override
	public void reset() {
		this.resetMaxHp(getMaxHp());
	}
}
