package game.entity.npc;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.action_types.BuyWeaponAction;
import game.action_types.SellWeaponAction;
import game.weapons.playerweapons.Club;
import game.weapons.playerweapons.GreatKnife;
import game.weapons.playerweapons.Uchigatana;

import java.util.HashMap;

public class Trader extends Actor {


    HashMap<String,Integer> weaponPrice = new HashMap<>();

    /**
     * Constructor.
     */
    public Trader() {
        super("Kale", 'K',0);
        weaponPrice.put("Club",100);
        weaponPrice.put("Great Knife",350);
        weaponPrice.put("Uchigatana",500);

    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new BuyWeaponAction(this, new Club(),600));
            actions.add(new BuyWeaponAction(this, new GreatKnife(),3500));
            actions.add(new BuyWeaponAction(this, new Uchigatana(),5000));
            for(WeaponItem weapon: otherActor.getWeaponInventory()){
                if(weapon.hasCapability(Status.SELLABLE)){
                    String weaponName = weapon.toString();
                    actions.add(new SellWeaponAction(this, weapon,weaponPrice.get(weaponName)));
                }



            }

        }
        return actions;
    }
}

