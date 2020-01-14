package za.co.wethinkcode;

// import java.util.Scanner;
import java.util.ArrayList;
import za.co.wethinkcode.model.DatabaseMethods;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
import za.co.wethinkcode.view.GameView;

/**
 * Swingy
 *
 */
public class App 
{
    public static ArrayList<Hero> makeVillains() {
        ArrayList<Hero> villainsList = new ArrayList<>();
        CharacterFactory characterFactory = new CharacterFactory();

        try {
            for (int i =0; i < 10; i++) {
                villainsList.add(characterFactory.createCharacter(CharacterType.VILLAIN, "Villain" + 1));
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return (villainsList);
    }
    public static void main( String[] args )
    {
        System.out.println("*********************************************");
        System.out.println("*                                           *");
        System.out.println("*    Welcome to the Swingy game             *");
        System.out.println("*                                           *");
        System.out.println("*********************************************");

        CharacterFactory characterFactory = new CharacterFactory();
        Hero hero;
        ArrayList<Hero> villains;
        GameView gameView = new GameView();
        char[][] map;
        DatabaseMethods dbMethods = new DatabaseMethods();
        int choice = 0;

        dbMethods.createDb();
        dbMethods.createTable();

        try {
            villains = makeVillains();
            choice = gameView.userChoice();
            if (choice == 1) {
                gameView.displayHeroes();
                hero = gameView.chooseHero();
                System.out.println("\nYou chose the following hero:\n");
                System.out.println(hero);
            }
            else {
                hero = gameView.makeHero();
                System.out.println("Here is your hero details:");
                System.out.println(hero);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
