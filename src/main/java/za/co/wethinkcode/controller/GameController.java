package za.co.wethinkcode.controller;

import java.util.Scanner;
import za.co.wethinkcode.model.Game;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;
import za.co.wethinkcode.factories.CharacterFactory;
import java.util.Random;

public class GameController {

    public GameController() {
    }

    public Hero makeHero(CharacterType type) throws Exception {
        CharacterFactory factory = new CharacterFactory();
        Scanner scanner = new Scanner(System.in);
        String userInput;

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

    
    public int combat(Hero hero, Hero villainHero) {
        // int result = -1;
        int heroHP = hero.getHeroHitPoints();
        int heroShield = hero.getHeroDefense();
        int heroAttack = hero.getHeroAttack();
        int villainAttack = villainHero.getHeroAttack();
        int villainShield = villainHero.getHeroDefense();
        int villainHP = villainHero.getHeroHitPoints();
        Random randomiser = new Random();
        int luckIndex;

        while (true) {
            luckIndex = randomiser.nextInt(5);
            System.out.println("HERO STATS:");
            System.out.println(hero);
            System.out.println("VILLAIN STATS:");
            System.out.println(villainHP);
            if ((luckIndex % 2) == 0) {
                if (villainShield > 0) {
                    heroAttack -= villainAttack;
                    villainHero.setHeroDefense(villainShield - heroAttack);
                    if (heroAttack > 0) {
                        villainHero.setHeroHitPoints(villainHP - heroAttack);
                        villainHP -= heroAttack;
                        // System.out.println("villain HP: " + villainHP);
                    }
                }
                else {
                    villainHP -= heroAttack;
                    // System.out.println("villain HP: " + villainHP);
                }
           }
           else {
                if (heroShield > 0) {
                    villainAttack -= villainAttack;
                    if (villainAttack > 0) {
                        heroHP -= villainAttack;
                        // System.out.println("Hero HP: " + heroHP);
                    }
                }
                else {
                    heroHP -= villainAttack;
                    // System.out.println("Hero HP: " + heroHP);
                }
           }
           if (heroHP <= 0) {
               return (0);
           }
           if (villainHP <= 0) {
             return (1);
           }
        }
    }

}