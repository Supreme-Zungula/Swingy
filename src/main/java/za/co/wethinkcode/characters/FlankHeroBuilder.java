package za.co.wethinkcode.characters;

import za.co.wethinkcode.interfaces.HeroBuilder;

public class FlankHeroBuilder implements HeroBuilder{
    private Hero flankHero;

    public FlankHeroBuilder() {
        this.flankHero = new Hero();
        this.flankHero.setHeroID();
    }

    // private static int nextID() {
    //     return (++idCounter);
    // }

    // public void buildHeroID() {
    //     int id = nextID();
    //     this.flankHero.setHeroID(id);
    // }

    public void buildHeroName(String name) {
        this.flankHero.setHeroName(name);
    }
  
    public void buildHeroClass() {
        this.flankHero.setHeroClass("Flank");
    }

    public void buildHeroLevel() {
        this.flankHero.setHeroLevel(1);
    }

    public void buildHeroExperience() {
        this.flankHero.setHeroExperience(0);
    }

    public void buildHeroAttack() {
        this.flankHero.setHeroAttack(1000);
    }

    public void buildHeroDefense() {
        this.flankHero.setHeroDefense(700);
    }

    public void buildHeroHitPoints() {
        this.flankHero.setHeroHitPoints(2000);
    }

    public Hero getHero() {
        return (this.flankHero);
    }
}