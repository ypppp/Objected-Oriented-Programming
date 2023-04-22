package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.entity.players.Bandit;
import game.entity.players.Player;
import game.entity.players.Samurai;
import game.entity.players.Wretch;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
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
		Player player;
		String selection;
		Scanner sel = new Scanner(System.in);
		do{
			System.out.println("Choose your class");
			System.out.println("1 for Samurai, 2 for Bandit and 3 for Wretch");
			selection = sel.nextLine();
		}while(Integer.parseInt(selection)<=0 || Integer.parseInt(selection)>3);

		if(Integer.parseInt(selection) == 1) {
			player = new Samurai();
		}
		else if(Integer.parseInt(selection) == 2){
			player = new Bandit();
		}
		else{
			player = new Wretch();
		}




		// HINT: what does it mean to prefer composition to inheritance?
//		Player player = new Player("Tarnished", '@', 300);
		world.addPlayer(player, gameMap.at(36, 10));

		world.run();
	}
}
