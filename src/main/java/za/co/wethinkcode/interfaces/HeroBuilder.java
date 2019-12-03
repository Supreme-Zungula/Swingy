package za.co.wethinkcode.interfaces;

import za.co.wethinkcode.heroes.Hero;

public interface HeroBuilder {
    public void buildHeroID();
    public void buildHeroName(String name);
    public void buildHeroClass();
    public void buildHeroLevel();
    public void buildHeroExperience();
    public void buildHeroAttack();
    public void buildHeroDefense();
    public void buildHeroHitPoints();
    public Hero getHero();
};