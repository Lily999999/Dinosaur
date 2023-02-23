package game;


import edu.monash.fit2099.engine.*;


/**
 * Public Application class that displays a map and respawning all the necessary
 * ground types and actors on a selected map, then the world runs to initiate a game.
 */
public class Application {



	/**
	 * main method that runs the program
	 */
	public static void main(String[] args) {
		Mode app = new Mode(new Display());
		app.run();
	}







	}
