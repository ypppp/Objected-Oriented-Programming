package game;

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
import game.action_types.reset.ResetManager;
import edu.monash.fit2099.engine.positions.Location;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new PuddleOfWater(), new Graveyard(), new GustOfWind(), new Cliff());

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

		List<String> roundTable = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######"
		);

//		List<String> StormVeilCastle = Arrays.asList(
//				"...........................................................................",
//				"..................<...............<........................................",
//				"...........................................................................",
//				"##############################################...##########################",
//				"............................#................#.......B..............B......",
//				".....B...............B......#................#.............................",
//				"...............................<.........<.................................",
//				".....B...............B......#................#.......B..............B......",
//				"............................#................#.............................",
//				"#####################..#############...############.####..#########...#####",
//				"...............#++++++++++++#................#++++++++++++#................",
//				"...............#++++++++++++...<.........<...#++++++++++++#................",
//				"...............#++++++++++++..................++++++++++++#................",
//				"...............#++++++++++++#................#++++++++++++#................",
//				"#####...##########.....#############...#############..#############...#####",
//				".._______........................B......B........................B.....B...",
//				"_____..._..____....&&........<..............<..............................",
//				".........____......&&......................................................",
//				"...._______..................<..............<....................<.....<...",
//				"#####....##...###..#####...##########___###############......##.....####...",
//				"+++++++++++++++++++++++++++#........___........#+++++++++++++++++++++++++++",
//				"+++++++++++++++++++++++++++.........___........#+++++++++++++++++++++++++++",
//				"+++++++++++++++++++++++++++#........___.........+++++++++++++++++++++++++++",
//				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++"
//		);
//
//		List<String> bossRoom = Arrays.asList(
//				"+++++++++++++++++++++++++",
//				".........................",
//				"..=......................",
//				"...................___...",
//				"...................___...",
//				"...................___...",
//				".........................",
//				".........................",
//				"+++++++++++++++++++++++++"
//		);

		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap roundTableMap = new GameMap(groundFactory,roundTable);
//		GameMap stormVeilMap = new GameMap(groundFactory,StormVeilCastle);
//		GameMap bossMap = new GameMap(groundFactory, bossRoom);

		world.addGameMap(gameMap);
//		world.addGameMap(stormVeilMap);
//		world.addGameMap(bossMap);
		world.addGameMap(roundTableMap);

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

		//add the trader to the map
		gameMap.at(40, 11).addActor(new Trader());

		// add the first site of lost grace
		TheSiteOfLostGrace firstSite = new TheSiteOfLostGrace("The First Step");
		firstSite.setHasActivate(true);
		TheSiteOfLostGrace.addFastTravelLocation(new Location(gameMap,38,11));
		gameMap.at(38,11).setGround(firstSite);

		// created the site of lost grace for all the maps
		roundTableMap.at(9,5).setGround(new TheSiteOfLostGrace("Table of Lost Grace"));
//		stormVeilMap.at(38,20).setGround(new TheSiteOfLostGrace("Stormveil Main Gate"));
//		bossMap.at(20,4).setGround(new TheSiteOfLostGrace("Godrick the Grafted"));

		//add the doorway to the roundtable map
		gameMap.at(34,8).setGround(new GoldenFogDoor(roundTableMap.at(9,10),"Roundtable Hold"));
		roundTableMap.at(9,10).setGround(new GoldenFogDoor(gameMap.at(34,8),"Limgrave"));

		//add the doorway to the stormveil map
//		gameMap.at(28,3).setGround(new GoldenFogDoor(stormVeilMap.at(36,23),"StormVeil Castle"));
//		stormVeilMap.at(28,3).setGround(new GoldenFogDoor(gameMap.at(28,3),"Limgrave"));

		//add the doorway to the boss room map
//		gameMap.at(6,20).setGround(new GoldenFogDoor(bossMap.at(13,7),"Boss Room"));
//		BossMap.at(13,7).setGround(new GoldenFogDoor(gameMap.at(6,20),"Limgrave"));


		ResetManager.getInstance().setSpawnPoint(gameMap.at(38,11));
		// HINT: what does it mean to prefer composition to inheritance?
		world.addPlayer(player, gameMap.at(36, 10));

		world.run();

	}
}
