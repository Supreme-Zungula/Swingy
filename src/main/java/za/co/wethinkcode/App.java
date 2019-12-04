package za.co.wethinkcode;

import za.co.wethinkcode.heroes.FlankHeroBuilder;
import za.co.wethinkcode.heroes.Hero;
import za.co.wethinkcode.heroes.TankHeroBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Hero tank = new Hero();
        Hero flank = new Hero();

        TankHeroBuilder tankBuilder = new TankHeroBuilder();
        FlankHeroBuilder flankHeroBuilder = new FlankHeroBuilder();
        
        tankBuilder.buildHeroID();
        tankBuilder.buildHeroName("Raum");
        flankHeroBuilder.buildHeroID();
        flankHeroBuilder.buildHeroName("Koga");
        
        tank = tankBuilder.getHero();
        flank = flankHeroBuilder.getHero();

        System.out.println(tank);
        System.out.println();
        System.out.println(flank);
    }
}
