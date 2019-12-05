package za.co.wethinkcode;

// import za.co.wethinkcode.characters.FlankHeroBuilder;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.characters.TankHeroBuilder;
// import za.co.wethinkcode.characters.TankHeroBuilder;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
/**
 * Hello world!
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

        try {
            tank = characterFactory.createCharacter(CharacterType.TANK,  "Devotion");
            dps = characterFactory.createCharacter(CharacterType.DAMAGE, "Kraber-kun");
            flank = characterFactory.createCharacter(CharacterType.FLANK, "Wingman");
            villain = characterFactory.createCharacter(CharacterType.VILLAIN, "Havoc");

            System.out.println(tank);
            System.out.println();
            System.out.println(flank);
            System.out.println();
            System.out.println(dps);
            System.out.println();
            System.out.println(villain);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
