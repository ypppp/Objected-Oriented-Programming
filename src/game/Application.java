package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.HeavySkeletonSwordsman;
import game.entity.enemies.LoneWolf;
import game.entity.enemies.PileOfBones;
import game.entity.npc.Trader;
import game.entity.players.Player;
import game.grounds.*;
import game.items.runes.Rune;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new PuddleOfWater(), new Graveyard(), new GustOfWind(), new TheSiteOfLostGrace());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#.....................&................",
				"......................#...........###....................&&................",
				"......nn..................................................&................",
				".......n...................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#___U____................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				".......~~~.................................................................",
				".......~...................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
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

		gameMap.at(23, 17).addActor(new PileOfBones(new HeavySkeletonSwordsman()));

		gameMap.at(56, 17).addActor(new LoneWolf());
		gameMap.at(56, 16).addActor(new LoneWolf());
		gameMap.at(57, 17).addActor(new GiantCrab());
		gameMap.at(55, 17).addActor(new LoneWolf());

		gameMap.at(40, 11).addActor(new Trader());

		gameMap.at(38,11).setGround(new TheSiteOfLostGrace());
		Rune rune = new Rune();
		rune.setAmount(200);
		gameMap.at(32,10).addItem(rune);

		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(37, 10));

		world.run();
	}
}
