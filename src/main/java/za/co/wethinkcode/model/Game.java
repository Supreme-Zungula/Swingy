package za.co.wethinkcode.model;

import java.util.Random;

import lombok.val;

import java.util.List;
import za.co.wethinkcode.characters.Hero;
/**
 * Game map
 */

public class Game {
    List<Hero> villainsList;
    char[][] map;
    int mapHeight;
    int mapWidth;

    public Game() {
        this.mapHeight = 0;
        this.mapWidth = 0;
    }

    public void generateMap(Hero hero) {
        this.mapHeight = (hero.getHeroLevel() - 1) * 5 + 10 - (hero.getHeroLevel() % 2);
        this.mapWidth = this.mapHeight;
        System.out.println("Height = " + this.mapHeight);
        System.out.println("Width = " + this.mapWidth);
        map = new char[mapWidth][mapHeight];

        for (int h = 0; h < this.mapHeight; h++) {
            for (int w = 0; w < this.mapWidth; w++) {
                this.map[h][w] = '*';
            }
        }
    }

    public void displayMap() {
        if (this.mapHeight == 0 || this.mapWidth == 0) {
            System.out.println("Cannot display: map is empty");
        } else {
            for (int h = 0; h < this.mapHeight; h++) {
                for (int w = 0; w < this.mapWidth; w++) {
                    System.out.print(map[w][h]);
                }
                System.out.println();
            }
        }
    }

    public void addCharacterToMap(Hero character){
        
        Random random = new Random();
        char value;

        if (character.getHeroClass().equals("Villain")) {
            value = 'V';
        }
        else {
            value = 'H';
        }

        while (true) {
            int x = random.nextInt(this.mapWidth);
            int y = random.nextInt(this.mapHeight);
            if (x == 0) x += 1;
            if (x == this.mapWidth) x -= 2;
            if (y == 0) y += 1;
            if (y == this.mapHeight) y -= 2;

            if (this.map[x][y] == '*'){
                this.map[x][y] = value;
                break;
            }
        }
    }
}