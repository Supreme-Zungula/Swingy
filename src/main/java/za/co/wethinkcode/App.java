package za.co.wethinkcode;

import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
import za.co.wethinkcode.model.Game;
/**
 * Swingy
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CharacterFactory characterFactory = new CharacterFactory();

        Hero dps;
        Hero tank;
        Hero flank;
        Hero villain;
        Game game;

        try {
            tank = characterFactory.createCharacter(CharacterType.TANK,  "Devotion");
            dps = characterFactory.createCharacter(CharacterType.DAMAGE, "Kraber");
            flank = characterFactory.createCharacter(CharacterType.FLANK, "Wingman");
            villain = characterFactory.createCharacter(CharacterType.VILLAIN, "Havoc");

            System.out.println(tank);
            System.out.println();
            System.out.println(flank);
            System.out.println();
            System.out.println(dps);
            System.out.println();
            System.out.println(villain);

            game = new Game();
            game.generateMap(tank);
            // game.displayMap();
            game.addCharacterToMap(tank);
            game.addCharacterToMap(flank);
            game.addCharacterToMap(flank);
            game.addCharacterToMap(villain);
            System.out.println();
            game.displayMap();

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
