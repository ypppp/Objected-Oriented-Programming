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

import game.items.RemembranceOfTheGrafted;
import game.items.runes.RuneManager;


/**
 * Abstract Class that represents the Player. It implements the Resettable interface.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Tong Jet Kit
 *
 */
public abstract class Player extends Actor implements Resettable {

	/**
	 * The menu UI for the player to choose their action
	 */
	private final Menu menu = new Menu();

	private int cursed_counter = 3;

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

	/**
	 * At each turn, select a valid action to perform.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the valid action that can be performed in that iteration or null if no valid action is found
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if(this.hasCapability(Status.CURSED)){
			this.hurt(10);
			cursed_counter -=1;
		}
		if(cursed_counter == 0){
			this.removeCapability(Status.CURSED);
			cursed_counter = 3;
		}

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

	/**
	 * To reset the player's hp to full
	 */
	@Override
	public void reset() {
		this.resetMaxHp(getMaxHp());
	}

	public Action died(){

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

}
