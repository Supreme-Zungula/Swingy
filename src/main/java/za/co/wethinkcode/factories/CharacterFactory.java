package za.co.wethinkcode.factories;

import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.characters.DamageHeroBuilder;
import za.co.wethinkcode.characters.TankHeroBuilder;
import za.co.wethinkcode.characters.VillainBuilder;
import za.co.wethinkcode.characters.FlankHeroBuilder;
import za.co.wethinkcode.enums.CharacterType;

public class CharacterFactory {
    private Hero newCharacter;

    public CharacterFactory() {
    }

    public Hero createCharacter(CharacterType type, String name) throws Exception {
  
        switch (type) {
        case FLANK:
            FlankHeroBuilder flankHeroBuilder = new FlankHeroBuilder();
            flankHeroBuilder.buildHeroName(name);
            flankHeroBuilder.buildHeroAttack();
            flankHeroBuilder.buildHeroClass();
            flankHeroBuilder.buildHeroDefense();
            flankHeroBuilder.buildHeroExperience();
            flankHeroBuilder.buildHeroHitPoints();
            flankHeroBuilder.buildHeroLevel();
            newCharacter = flankHeroBuilder.getHero();
            break;
        case DAMAGE:
            DamageHeroBuilder dmgBuilder = new DamageHeroBuilder();
            dmgBuilder.buildHeroName(name);
            dmgBuilder.buildHeroAttack();
            dmgBuilder.buildHeroClass();
            dmgBuilder.buildHeroDefense();
            dmgBuilder.buildHeroExperience();
            dmgBuilder.buildHeroHitPoints();
            dmgBuilder.buildHeroLevel();
            newCharacter = dmgBuilder.getHero();
            break;

        case TANK:
            TankHeroBuilder tankBuidler = new TankHeroBuilder();
            tankBuidler.buildHeroName(name);
            tankBuidler.buildHeroAttack();
            tankBuidler.buildHeroClass();
            tankBuidler.buildHeroDefense();
            tankBuidler.buildHeroExperience();
            tankBuidler.buildHeroHitPoints();
            tankBuidler.buildHeroLevel();
            newCharacter = tankBuidler.getHero();
            break;
        
        case VILLAIN:
            VillainBuilder villainBuidler = new VillainBuilder();
            villainBuidler.buildHeroName(name);
            villainBuidler.buildHeroAttack();
            villainBuidler.buildHeroClass();
            villainBuidler.buildHeroDefense();
            villainBuidler.buildHeroExperience();
            villainBuidler.buildHeroHitPoints();
            villainBuidler.buildHeroLevel();
            newCharacter = villainBuidler.getHero();
            break;

        default:
            throw new Exception("ERROR: Invalid character type");
        }
        return (newCharacter);
    }
}