package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import edu.monash.fit2099.engine.*;

/**
 * A public class that allow Player to choose one of two game modes.
 */
public class Mode extends World{



    /**
     * private attribute integer for an input of eco points
     */
    private  int ecoChallenge;

    /**
     * private attribute integer for an input of a number of turns
     */
    private  int turnChallenge;

    /**
     * private attribute boolean for challenge
     */
    private  boolean challenge;

    /**
     * private attribute integer for initialized turn
     */
    private int turns = 1;

    /**
     * private instance of Display class
     */
    private  Display display = new Display();

    /**
     * private Scanner class to read a key
     */
    private   Scanner input = new Scanner(System.in);



    /**
     * Constructor
     *
     * @param display the Display that will display this World.
     */
    public Mode(Display display) {
        super(display);
    }

    /**
     *  runs the program with game modes
     */
    public void run() {



        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree());
        List<String> map = Arrays.asList(
                "................................................................................",
                "................................................................................",
                ".....#######....................................................................",
                ".....#_____#....................................................................",
                ".....#_____#....................................................................",
                ".....###.###....................................................................",
                "................................................................................",
                "......................................+++.......................................",
                ".......................................++++.....................................",
                "...................................+++++........................................",
                ".....................................++++++.....................................",
                "......................................+++.......................................",
                ".....................................+++........................................",
                "................................................................................",
                "............+++.................................................................",
                ".............+++++..............................................................",
                "...............++........................................+++++..................",
                ".............+++....................................++++++++....................",
                "............+++.......................................+++.......................",
                "................................................................................",
                ".........................................................................++.....",
                "........................................................................++.++...",
                ".........................................................................++++...",
                "..........................................................................++....",
                "................................................................................");
        GameMap gameMap = new GameMap(groundFactory, map);
        this.addGameMap(gameMap);

        List<String> SecondMap = Arrays.asList(
                "................................................................................",
                "................................................................................",
                ".............................................+++................................",
                "........++......................................................................",
                "........+.......................................................................",
                "................................................................................",
                "................................................................................",
                "......................................+++.......................................",
                ".......................................++++.....................................",
                "................................................................................",
                ".....................................+..........................................",
                "......................................+.........................................",
                ".....................................+++........................................",
                "................................................................................",
                "............+++.................................................................",
                "................................................................................",
                ".........................................................+++++..................",
                ".............+..................................................................",
                "............+++.......................................+++.......................",
                "................................................................................",
                ".........................................................................++.....",
                "........................................................................++.++...",
                ".............................................++.................................",
                "..........................................................................++....",
                "................................................................................");

        GameMap Second = new GameMap(groundFactory, SecondMap);
        this.addGameMap(Second);

        Actor player = new Player("Player", '@', 100);
        this.addPlayer(player, gameMap.at(9, 4));


        gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur", true));
        gameMap.at(42, 15).addActor(new Stegosaur("Stegosaur", false));
        gameMap.at(55, 1).addActor(new Brachiosaur("Brachiosaur", true));
        gameMap.at(15, 10).addActor(new Brachiosaur("Brachiosaur", true));
        gameMap.at(13, 21).addActor(new Brachiosaur("Brachiosaur", false));
        gameMap.at(15, 23).addActor(new Brachiosaur("Brachiosaur", false));
        gameMap.at(35, 9).addActor(new Pterodactyls("Pterodactyls", true));
        gameMap.at(38, 7).addActor(new Pterodactyls("Pterodactyls", false));
        generateBush(gameMap);
        generateLake(gameMap);
        gameMap.at(12, 7).setGround(new VendingMachine());
        Passage pass = new Passage();
        pass.addAction(new MoveActorAction(Second.at(1, 24), "to the second map"));
        gameMap.at(1, 0).addItem(pass);
        Passage SecondPass = new Passage();
        SecondPass.addAction(new MoveActorAction(gameMap.at(1, 0), "to the first map"));
        Second.at(1, 24).addItem(SecondPass);
        this.display.println("Please select Challenge or Sandbox mode: 1 for Challenge, 2 for Sandbox, 3 for quit");
        Scanner scan = new Scanner(System.in);
        String choose = scan.nextLine();
        option(choose);
        super.run();
        // After finish the challenge mode, player can play the game again without needing to run the program again.
        this.run();


    }




    /**
     * private void method that generates bush on the ground if the ground type is dirt.
     *
     * @param gameMap the map to generate bush
     */
    private  void generateBush(GameMap gameMap) {
        for (int i = 0; i < gameMap.getXRange().max(); i++) {
            for (int j = 0; j < gameMap.getYRange().max(); j++) {
                if (gameMap.at(i, j).getGround() instanceof Dirt) {
                    double random = Math.random() * 100;
                    if (random <= 2)
                        gameMap.at(i, j).setGround(new Bush());
                }


            }
        }
    }

    /**
     * private void method that generates lakes on the ground if the ground type is dirt.
     *
     * @param gameMap the map to generate lakes
     */
    private  void generateLake(GameMap gameMap) {
        for (int i = 0; i < gameMap.getXRange().max(); i++) {
            for (int j = 0; j < gameMap.getYRange().max(); j++) {
                if (gameMap.at(i, j).getGround() instanceof Dirt) {
                    double random = Math.random() * 100;
                    if (random <= 2)
                        gameMap.at(i, j).setGround(new Lake());
                }
            }
        }
    }


    /**
     * public method that controls the game mode: challenge or sandbox mode.
     *
     * It throws a RuntimeError when Player enter a different input other than 1,2, 3.
     * For challenge, it asks Player for turn limit and target eco points.
     * For sandbox, everything is the same.
     */
    public  void option(String character){


        switch (character) {
            case "2" -> {
                this.challenge = false;
                break;
            }
            case "1" -> {
                this.challenge = true;
                this.display.println("Please input turn limit: ");
                int targetTurns = Integer.parseInt(input.nextLine());
                this.display.println("Please input target eco points: ");
                int targetEco = Integer.parseInt(input.nextLine());
                this.turnChallenge = targetTurns;
                this.ecoChallenge = targetEco;
                break;
            }
            case "3" -> {
                this.display.println("Game End");
                System.exit(0);
            }
            default -> throw new RuntimeErrorException(null, "Wrong input");
        }

    }


    /**
     * Update Player's turns
     * @param actor the Actor whose turn it is.
     */
   @Override
    protected  void processActorTurn(Actor actor) {
       super.processActorTurn(actor);
        if (actor instanceof Player) {

            if (this.challenge) {

                this.turns++;
                this.display.println("Now is Turn " + turns );

            }
        }
    }

    /**
     * Check if the number of Player's turn exceeds turnChallenge or Player's eco points reach ecoChallenge.
     * @return boolean end the game if target eco points is reached or turn limit is reached
     */
    @Override
    protected  boolean stillRunning () {


        if (this.challenge) {
            if (this.turns > this.turnChallenge || ((Player) this.player).getEco() >= this.ecoChallenge) {
                return false;



            }
        }

        return true;
    }

    /**
     * Print end game message.
     * @return String Player's score and whether Player wins or loses
     */
    @Override
    protected String endGameMessage() {

        turns = 1;
        String Str = null;
        if (this.player instanceof Player) {
            int playerPoints = ((Player) this.player).getEco();
            Str = "Eco points: " + playerPoints + "\n";
            if (this.challenge) {
                Str += "Eco point goal: " + this.ecoChallenge + "\n";
                Str += "Number of turn limit: " + this.turnChallenge + "\n";
                if (playerPoints >= this.ecoChallenge) {
                    Str += "Target eco points reached, you win!\n";
                } else {
                    Str += "Target eco points not reached, you lose!\n";
                }
            }

        }
        Str += super.endGameMessage() + "\n";
        return Str;
    }


}
