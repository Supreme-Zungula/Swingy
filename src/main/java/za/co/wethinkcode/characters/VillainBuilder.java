package za.co.wethinkcode.characters;

import java.util.Random;
import za.co.wethinkcode.interfaces.HeroBuilder;

public class VillainBuilder implements HeroBuilder
{
    private Hero villainHero;
    private Random randNumGenerator;

    public VillainBuilder()
    {
        randNumGenerator = new Random();
        villainHero = new Hero();
        this.villainHero.setHeroID();
    }

    public void buildHeroName(String name) {
        this.villainHero.setHeroName(name);
    }
  
    public void buildHeroClass() {
        this.villainHero.setHeroClass("Villain");
    }

    public void buildHeroLevel() {
        int level = randNumGenerator.nextInt(100) + 1;
        this.villainHero.setHeroLevel(level);
    }

    public void buildHeroExperience() {
        int exp = randNumGenerator.nextInt(100) + 1;
        this.villainHero.setHeroExperience(exp * 100);
    }

    public void buildHeroAttack() {
        int attack = randNumGenerator.nextInt(20) + 1;
        this.villainHero.setHeroAttack(attack * 100);
    }

    public void buildHeroDefense() {
        int defense = randNumGenerator.nextInt(10) + 1;
        this.villainHero.setHeroDefense(defense * 100);
    }

    public void buildHeroHitPoints() {
        int hp = randNumGenerator.nextInt(50) + 1;
        this.villainHero.setHeroHitPoints(hp * 100);
    }

    public Hero getHero() {
        return (this.villainHero);
    }
}