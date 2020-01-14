package za.co.wethinkcode.view;

import java.util.Scanner;
import java.util.List;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.controller.GameController;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;

public class GameView 
{
    private GameController gameController;
    private Hero hero;
    private List<Hero>  heroesList;
    private Game game;
    private char[][] map;

    public GameView() 
    {
        this.gameController = new GameController();
        this.game = new Game();
        this.map = game.getMap();
        this.heroesList = gameController.getHeroesFromDB();
    }

    public int userChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Enter a number corresponding to your choice.");
            System.out.println("1. Pick character from database.");
            System.out.println("2. Make your own character.");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid option, try again.");
            }
            else {
                break;
            }
        }
        return (choice);
    }

    /*
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String input;

        while (true) {
            System.out.println("Enter a number corresponding to your choice.");
            System.out.println("1. Pick character from database.");
            System.out.println("2. Make your own character.");
            input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice == 1) {
                    System.out.println("choose a character from the list below.");
                    heroesList = this.gameController.getHeroesFromDB();
                    this.hero = chooseHero();
                    if (this.hero == null) {
                        System.out.println("Hero not found.");
                    }
                    break;
                } 
                else if (choice == 2) {
                    System.out.println("Make your own character.");
                    this.hero = this.gameController.makeHero(this.chooseHeroClass());
                    System.out.println(this.hero);
                    this.game.setHero(this.hero);
                    break;
                } else {
                    System.out.println("Voetsek satan. Can't you read instructions?");
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Voetsek satan. Can't you read instructions?");
            }
        }
        scanner.close();
    }
    */
    public Hero makeHero() {
        Hero newHero = null;
        CharacterType heroType = chooseHeroClass();
        
        try {
            newHero =this.gameController.makeHero(heroType);
        } catch (Exception e) {
            System.out.println("ERROR: could not make the hero.");
        }
        return (newHero);
    }
    public Hero chooseHero() {
        // Hero newHero;
        Scanner scanner = new Scanner(System.in);
        int heroID;

        for (Hero hero : heroesList) {
            System.out.println(hero);
            System.out.println();
        }

        System.out.println("Enter the ID of the hero you want:");
        heroID = scanner.nextInt();
        for (Hero hero : heroesList) {
            if (hero.getHeroID() == heroID) {
                return (hero);
            }
        }
        return (null);
    }

    public void displayHeroes() {
        System.out.println("Heroes list:");
        for (Hero hero : heroesList ) {
            System.out.println(hero);
        }
    }

    public CharacterType chooseHeroClass() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;

        while (true) {
            System.out.println("Choose a hero class.");
            System.out.println("1. Damage class");
            System.out.println("2. Flank class");
            System.out.println("3. Tank class");

            input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                switch (choice) {
                case 1:
                    return (CharacterType.DAMAGE);
                case 2:
                    return (CharacterType.FLANK);
                case 3:
                    return (CharacterType.TANK);
                default:
                    System.out.println("Voetsek wena! can't you see the options you were given?");
                }
            } catch (Exception ex) {
                System.out.println("Voetsek choose again you fool.");
                scanner.close();
            }
        }
    }

    public void addCharacterToGame(Hero character) {
        this.game.addCharacterToMap(character);
    }

    public void mapNavigation() {
        Scanner scanner = new Scanner(System.in);
        String move;
        System.out.println("Use WASD for navigation or Q to quit:");
        while (true) {
            move = scanner.next();
            System.out.println(move);

            if (move.toLowerCase() == "q") {
                break;
            }
        }
    }

    public void makeMap(Hero hero) {
        this.game.generateMap(hero);
    }

    public int getMapHeight() {
        return (this.game.getMapHeight());
    }

    public int getMapWidth() {
        return (this.game.getMapWidth());
    }
    
    public char[][] getMap() 
    {
        return (this.game.getMap());
    }

    public void displayMap() {
        this.game.displayMap();
    }

    public Hero getHero() {
        return (this.hero);
    }
}