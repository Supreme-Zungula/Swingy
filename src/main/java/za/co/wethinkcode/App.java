package za.co.wethinkcode;

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
        TankHeroBuilder tankBuilder = new TankHeroBuilder();
        tankBuilder.buildHeroID();
        tankBuilder.buildHeroName("Raum");
        tankBuilder.buildHeroLevel();
        tankBuilder.buildHeroHitPoints();
        tankBuilder.buildHeroExperience();
        tankBuilder.buildHeroDefense();
        tankBuilder.buildHeroClass();
        tankBuilder.buildHeroAttack();
        tank = tankBuilder.getHero();
        System.out.println(tank);
    }
}
