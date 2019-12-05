package za.co.wethinkcode.characters;

import za.co.wethinkcode.interfaces.HeroBuilder;

public class TankHeroBuilder implements HeroBuilder{
    private Hero tankHero;
    private static int idCounter;

    public TankHeroBuilder() {
        this.tankHero = new Hero();
        this.tankHero.setHeroID();
    }

    // private static int nextID() {
    //     return (++idCounter);
    // }

    // public void buildHeroID() {
    //     int id = nextID();
    //     this.tankHero.setHeroID(id);
    // }

    public void buildHeroName(String name) {
        this.tankHero.setHeroName(name);
    }
  
    public void buildHeroClass() {
        this.tankHero.setHeroClass("Tank");
    }

    public void buildHeroLevel() {
        this.tankHero.setHeroLevel(1);
    }

    public void buildHeroExperience() {
        this.tankHero.setHeroExperience(0);
    }

    public void buildHeroAttack() {
        this.tankHero.setHeroAttack(800);
    }

    public void buildHeroDefense() {
        this.tankHero.setHeroDefense(2000);
    }

    public void buildHeroHitPoints() {
        this.tankHero.setHeroHitPoints(5000);
    }

    public Hero getHero() {
        return (this.tankHero);
    }
}