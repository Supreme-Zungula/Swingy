package za.co.wethinkcode.controller;

import java.util.Scanner;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;

public class GameController {
    private Game game;

    public GameController() {
        this.game = new Game();
    }

    public void addHero(Hero hero) {
        this.game.setHero(hero);
    }

    public void makeMap(Hero hero) {
        this.game.generateMap(hero);
    }

    public void displayMap() {
        this.game.displayMap();
    }

    public void addCharacterToGame(Hero character) {
        this.game.addCharacterToMap(character);
    }

    public Hero makeHero() throws Exception {
        CharacterFactory factory = new CharacterFactory();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        CharacterType type = this.chooseHeroClass();

        while (true) {
            System.out.println("Enter your hero's name:");
            userInput = scanner.nextLine();    
            if (userInput.trim().length() == 0) {
                System.out.println("Voetsek! what nonsense is this?");
            } else {
                return (factory.createCharacter(type, userInput));
            }
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
            }
        }
    }

    public void runGame() {
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
                    break;
                } else if (choice == 2) {
                    System.out.println("Make your own character.");
                    System.out.println(makeHero());
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
}