package za.co.wethinkcode;

import java.util.Scanner;
import za.co.wethinkcode.model.DatabaseMethods;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
// import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.view.GameView;
// import za.co.wethinkcode.controller.GameController;;
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
        // Game game = new Game();
        // GameController gameController = new GameController();
        GameView gameView = new GameView();
        DatabaseMethods dbMethods = new DatabaseMethods();

        dbMethods.createDb();
        dbMethods.createTable();

        try {
            tank = characterFactory.createCharacter(CharacterType.TANK,  "Devotion");
            dps = characterFactory.createCharacter(CharacterType.DAMAGE, "Kraber");
            flank = characterFactory.createCharacter(CharacterType.FLANK, "Wingman");
            villain = characterFactory.createCharacter(CharacterType.DAMAGE, "Havoc");
            
            // dbMethods.addHero(tank);
            // dbMethods.addHero(flank);
            // dbMethods.addHero(dps);
            // dbMethods.addHero(villain);
            // dbMethods.selectAll();
            // dbMethods.showAll();
            
            gameView.getUserInput();
            gameView.makeMap(tank);
            gameView.displayMap();

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
