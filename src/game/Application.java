package game;

import java.lang.reflect.Array;
import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.entity.enemies.*;
import game.entity.players.Bandit;
import game.entity.npc.Trader;
import game.entity.players.Player;
import game.entity.players.Samurai;
import game.entity.players.Wretch;
import game.grounds.*;
import game.items.GoldenRunes;
import game.items.RemembranceOfTheGrafted;
import game.items.runes.Rune;
import game.items.runes.RuneManager;
import game.action_types.reset.ResetManager;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static <Char> void main(String[] args) {

		Display display = new Display();

		World world = new World(display);

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new PuddleOfWater(), new Graveyard(), new GustOfWind());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"........nn........................__#......................................",
				".......nnn............._____........#......................................",
				".......nn.............#............_#.....................&&...............",
				"......................#...........###....................&&&...............",
				"..........................................................&................",
				"...........................................................................",
				"..................................###___###..................nn............",
				"..................................________#.................nnn............",
				".......&&&&.......................#________..................nn............",
				"......&&&&........................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................~~~~~~~~~~~~~~~~",
				"~~~~~~~~~~..................................................~~~~.....~~~~~.",
				".....~~~...................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		ArrayList<GameMap>maps = new ArrayList<>();
		maps.add(gameMap);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

//		gameMap.at(23, 17).addActor(new PileOfBones(new HeavySkeletonSwordsman()));
//
//		gameMap.at(56, 17).addActor(new LoneWolf());
//		gameMap.at(56, 16).addActor(new LoneWolf());

		HashMap<Character,Player> classesMap = new HashMap<Character, Player>();
		classesMap.put('S',new Samurai());
		classesMap.put('s', new Samurai());
		classesMap.put('W',new Wretch());
		classesMap.put('w',new Wretch());
		classesMap.put('B', new Bandit());
		classesMap.put('b',new Bandit());

		// at here add a menu to select who what class
		char chosenClass;
		Player player;
		//use hashmap to storethe classes and use contains key and get(key)
		do{
			display.println("Choose a class\n S for Samurai\n B for Bandit\n W for Wretch");
			chosenClass = display.readChar();
		} while(!classesMap.containsKey(chosenClass));

		player = classesMap.get(chosenClass);

		for(GameMap gameMaps:maps) {
			for (int i = 0; i < 25; i++) {
				int x_coordinate = RandomNumberGenerator.getRandomInt(gameMap.getXRange().min(), gameMap.getXRange().max());
				int y_coordinate = RandomNumberGenerator.getRandomInt(gameMap.getYRange().min(), gameMap.getYRange().max());
				if (gameMap.at(x_coordinate, y_coordinate).getGround().hasCapability(Status.CAN_HAVE_GOLDEN_RUNES)) {
					if (gameMap.at(x_coordinate, y_coordinate).getItems().isEmpty()) {
						gameMap.at(x_coordinate, y_coordinate).addItem(new GoldenRunes());
					}
				}
			}
		}


		ArrayList<Status>kaleAction = new ArrayList<>();
		kaleAction.add(Status.SELLABLE);
		kaleAction.add(Status.PURCHASABLE);

		gameMap.at(40, 11).addActor(new Trader("Kale", 'K', kaleAction));

		ArrayList<Status>eniaAction = new ArrayList<>();
		eniaAction.add(Status.SELLABLE);
		eniaAction.add(Status.EXCHANGEABLE);

		gameMap.at(35,10).addActor(new Trader("Enia", 'E', eniaAction));

		gameMap.at(38,11).setGround(new TheSiteOfLostGrace("The First Step"));

		gameMap.at(35, 11).addItem(new GoldenRunes());

		ResetManager.getInstance().setSpawnPoint(gameMap.at(38,11));
		// HINT: what does it mean to prefer composition to inheritance?
		world.addPlayer(player, gameMap.at(36, 10));


		world.run();

	}
}
