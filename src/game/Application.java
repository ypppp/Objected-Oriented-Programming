package game;

import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.entity.enemies.*;
import game.entity.players.*;
import game.entity.npc.Trader;
import game.grounds.*;
import game.items.GoldenRunes;
import game.items.RemembranceOfTheGrafted;
import game.items.runes.Rune;
import game.items.runes.RuneManager;
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


		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new PuddleOfWater(), new Graveyard(), new GustOfWind(), new Cliff(), new Cage(), new Barrack(), new ChurchOfIrith());


		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#.....................&&...............",
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

		List<String> StormVeilCastle = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#........___........#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++.........___........#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#........___.........+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++"
		);

		List<String> bossRoom = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				".........................",
				"...................___...",
				"...................___...",
				"...................___...",
				".........................",
				".........................",
				"+++++++++++++++++++++++++"
		);

		List<String> church = Arrays.asList(
				"#############",
				"#___________#",
				"#_____^_____#",
				"#___________#",
				"#___________#",
				"##_________##"
		);

		GameMap gameMap = new GameMap(groundFactory, map);
		GameMap roundTableMap = new GameMap(groundFactory,roundTable);
		GameMap stormVeilMap = new GameMap(groundFactory,StormVeilCastle);
		GameMap bossMap = new GameMap(groundFactory, bossRoom);
		GameMap churchMap = new GameMap(groundFactory, church);

		world.addGameMap(gameMap);
		world.addGameMap(stormVeilMap);
		world.addGameMap(bossMap);
		world.addGameMap(roundTableMap);
		world.addGameMap(churchMap);
		
		ArrayList<GameMap>maps = new ArrayList<>();
		maps.add(gameMap);
		maps.add(stormVeilMap);
		maps.add(roundTableMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		gameMap.at(23, 17).addActor(new PileOfBones(new HeavySkeletonSwordsman()));
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
		classesMap.put('A', new Astrologer());
		classesMap.put('a', new Astrologer());

		// at here add a menu to select who what class
		char chosenClass;
		Player player;
		//use hashmap to store the classes and use contains key and get(key)
		do{
			display.println("Choose a class\n S for Samurai\n B for Bandit\n W for Wretch\n A for Astrologer");
			chosenClass = display.readChar();
		} while(!classesMap.containsKey(chosenClass));

		player = classesMap.get(chosenClass);

		// add the goldenRunes
		for(GameMap gameMaps:maps) {
			for (int i = 0; i < 25; i++) {
				int x_coordinate = RandomNumberGenerator.getRandomInt(gameMaps.getXRange().min(), gameMaps.getXRange().max());
				int y_coordinate = RandomNumberGenerator.getRandomInt(gameMaps.getYRange().min(), gameMaps.getYRange().max());
				if (gameMaps.at(x_coordinate, y_coordinate).getGround().hasCapability(Status.CAN_HAVE_GOLDEN_RUNES)) {
					if (gameMaps.at(x_coordinate, y_coordinate).getItems().isEmpty()) {
						gameMaps.at(x_coordinate, y_coordinate).addItem(new GoldenRunes());
					}
				}
			}
		}

		//add the trader to the map
		ArrayList<Status>kaleAction = new ArrayList<>();
		kaleAction.add(Status.SELLABLE);
		kaleAction.add(Status.PURCHASABLE);

		gameMap.at(40, 11).addActor(new Trader("Kale", 'K', kaleAction));

		ArrayList<Status>eniaAction = new ArrayList<>();
		eniaAction.add(Status.SELLABLE);
		eniaAction.add(Status.EXCHANGEABLE);

		gameMap.at(35,11).addActor(new Trader("Enia", 'E', eniaAction));


		// add the first site of lost grace
		TheSiteOfLostGrace firstSite = new TheSiteOfLostGrace("The First Step");
		firstSite.setHasActivate(true);
		gameMap.at(38,11).setGround(firstSite);

//		add the SummonSign
		SummonSign summonSign = new SummonSign(bossMap.at(2,2));
		bossMap.at(2,2).setGround(summonSign);

		// created the site of lost grace for all the maps
		roundTableMap.at(9,5).setGround(new TheSiteOfLostGrace("Table of Lost Grace"));
		stormVeilMap.at(37,21).setGround(new TheSiteOfLostGrace("Stormveil Main Gate"));
		bossMap.at(20,4).setGround(new TheSiteOfLostGrace("Godrick the Grafted"));

		//add the doorway to the roundtable map
		gameMap.at(34,8).setGround(new GoldenFogDoor(roundTableMap.at(9,10),"Roundtable Hold"));
		roundTableMap.at(9,10).setGround(new GoldenFogDoor(gameMap.at(34,8),"Limgrave"));

		//add the doorway to the stormveil map
		gameMap.at(28,3).setGround(new GoldenFogDoor(stormVeilMap.at(36,23),"StormVeil Castle"));
		stormVeilMap.at(36,23).setGround(new GoldenFogDoor(gameMap.at(28,3),"Limgrave"));

//		add the doorway to the boss room map
		stormVeilMap.at(50,1).setGround(new GoldenFogDoor(bossMap.at(13,7),"Ancestral Woods"));
		bossMap.at(13,7).setGround(new GoldenFogDoor(stormVeilMap.at(50,1),"StormVeil Castle"));


		ResetManager.getInstance().setSpawnPoint(gameMap.at(38,11));
		// HINT: what does it mean to prefer composition to inheritance?
		RuneManager.getInstance().getRune().setAmount(200);

		GoldenFogDoor churchDoor = new GoldenFogDoor(churchMap.at(6,5),"Church of Irith");
		churchMap.at(6,5).setGround(new GoldenFogDoor(bossMap.at(23,1),"Ancestral Woods"));

		bossMap.at(5,5).addActor(new RegalAncestorSpirit(bossMap.at(23,1),churchDoor));

		world.addPlayer(player, gameMap.at(37, 10));

		world.run();

	}
}
