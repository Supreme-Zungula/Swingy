package za.co.wethinkcode.heroes;

import za.co.wethinkcode.interfaces.HeroBuilder;

public class DamageHeroBuilder implements HeroBuilder{
    private Hero damageHero;
    private static int idCounter;

    public DamageHeroBuilder() {
        this.damageHero = new Hero();
    }

    private static int nextID() {
        return (++idCounter);
    }

    public void buildHeroID() {
        int id = nextID();
        this.damageHero.setHeroID(id);
    }

    public void buildHeroName(String name) {
        this.damageHero.setHeroName(name);
    }
  
    public void buildHeroClass() {
        this.damageHero.setHeroClass("Tank");
    }

    public void buildHeroLevel() {
        this.damageHero.setHeroLevel(1);
    }

    public void buildHeroExperience() {
        this.damageHero.setHeroExperience(0);
    }

    public void buildHeroAttack() {
        this.damageHero.setHeroAttack(800);
    }

    public void buildHeroDefense() {
        this.damageHero.setHeroDefense(1000);
    }

    public void buildHeroHitPoints() {
        this.damageHero.setHeroHitPoints(5000);
    }

    public Hero getHero() {
        return (this.damageHero);
    }
}