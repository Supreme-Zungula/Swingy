package za.co.wethinkcode.view;

import java.util.List;
import za.co.wethinkcode.controller.GameController;
import za.co.wethinkcode.characters.Hero;

public class GameView 
{
    private GameController gameController;
    private Hero hero;
    private List<Hero>  villainsList;

    public GameView() {
        this.gameController = new GameController();
    }

    public void setHero(Hero hero) {
        this.gameController.addHero(hero);
        this.hero = hero;
    }

    public void setMap(Hero hero) {
        this.gameController.makeMap(hero);
    }

    public void displayMap() {
        this.gameController.displayMap();
    }
}