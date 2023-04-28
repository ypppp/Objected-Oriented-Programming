package game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.entity.enemies.GiantCrab;
import game.entity.enemies.HeavySkeletonSwordsman;
import game.entity.players.Bandit;
import game.entity.players.Player;
import game.entity.players.Samurai;
import game.entity.players.Wretch;
import game.grounds.*;

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
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#.....................&................",
				"......................#...........###....................&&................",
				"......nn..................................................&................",
				".......n...................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
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

		gameMap.at(23, 17).addActor(new LoneWolf());


		// at here add a menu to select who what class
		ArrayList<Character> validClasses = new ArrayList<>(Arrays.asList('S', 'B','W'));
		char chosenClass;
		Player player;

		do{
			display.println("Choose a class\n S for Samurai\n B for Bandit\n W for Wretch");
			chosenClass = display.readChar();
		} while(!validClasses.contains(chosenClass));

		switch(chosenClass){
			case 'S':
				player = new Samurai();
				break;
			case 'B':
				player = new Bandit();
				break;
			case 'W':
				player = new Wretch();
				break;
			default:
				player = new Samurai();
		}



		gameMap.at(56, 17).addActor(new LoneWolf());
		gameMap.at(56, 16).addActor(new LoneWolf());
		gameMap.at(57, 17).addActor(new GiantCrab());
		gameMap.at(55, 17).addActor(new LoneWolf());
		gameMap.at(33, 10).addActor(new HeavySkeletonSwordsman());

		// HINT: what does it mean to prefer composition to inheritance?
		world.addPlayer(player, gameMap.at(36, 10));

		world.run();
	}
}
