package za.co.wethinkcode;

import java.util.Scanner;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.view.GameView;
import za.co.wethinkcode.controller.GameController;;
/**
 * Swingy
 *
 */
public class App 
{
    private static Scanner scanner;
    public static void main( String[] args )
    {
        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*    Welcome to the Swingy game             *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

        CharacterFactory characterFactory = new CharacterFactory();
        Hero dps;
        Hero tank;
        Hero flank;
        Hero villain;
        // Game game;
        GameController gameController = new GameController();
        GameView gameView = new GameView();

        try {
            tank = characterFactory.createCharacter(CharacterType.TANK,  "Devotion");
            dps = characterFactory.createCharacter(CharacterType.VILLAIN, "Kraber");
            flank = characterFactory.createCharacter(CharacterType.VILLAIN, "Wingman");
            villain = characterFactory.createCharacter(CharacterType.VILLAIN, "Havoc");
            tank.setHeroLevel(1);
            // game = new Game();
            // game.generateMap(tank);
            // game.displayMap();
            // gameController.addHero(tank);
            // gameView.getUserInput();
        
            if (gameController.combat(flank, villain) == 1) {
                System.out.println("You won.");
            }
            else {
                System.out.println("You got wrecked.");
            }
            // System.out.println(gameController.getGame().getHero());
            // gameController.makeMap(tank);
            // gameController.addCharacterToGame(tank);
            // gameController.addCharacterToGame(dps);
            // gameController.addCharacterToGame(flank);
            // gameController.addCharacterToGame(villain);
            // gameController.displayMap();
            
            // System.out.println("Character positions on the map:");
            // System.out.println(tank.getPosition());
            // System.out.println(flank.getPosition());
            // System.out.println(dps.getPosition());
            // System.out.println(villain.getPosition());

            // game.addCharacterToMap(tank);
            // game.addCharacterToMap(flank);
            // game.addCharacterToMap(flank);
            // game.addCharacterToMap(villain);
            // System.out.println();
            // game.displayMap();

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Scanner getScanner() {
        if(scanner != null)
           return scanner;
        scanner = new Scanner(System.in);
        return scanner;
    }

}
