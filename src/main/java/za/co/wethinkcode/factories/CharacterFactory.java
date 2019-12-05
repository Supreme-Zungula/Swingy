package za.co.wethinkcode.factories;

import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.characters.DamageHeroBuilder;
import za.co.wethinkcode.characters.TankHeroBuilder;
import za.co.wethinkcode.characters.FlankHeroBuilder;
import za.co.wethinkcode.enums.CharacterType;

public class CharacterFactory 
{
    private Hero newCharacter;
    
    public CharacterFactory()
    {
        newCharacter = new Hero();
    }

    public Hero createCharacter(CharacterType type, String name) throws Exception
    {
        switch (type) {
            case FLANK:
                FlankHeroBuilder flankHeroBuilder = new FlankHeroBuilder();
                flankHeroBuilder.buildHeroID();
                flankHeroBuilder.buildHeroName(name);
                flankHeroBuilder.buildHeroAttack();
                flankHeroBuilder.buildHeroClass();
                flankHeroBuilder.buildHeroDefense();
                flankHeroBuilder.buildHeroExperience();
                flankHeroBuilder.buildHeroHitPoints();
                flankHeroBuilder.buildHeroLevel();
                newCharacter = flankHeroBuilder.getHero();
                return (newCharacter);

            case DAMAGE:
                DamageHeroBuilder dmgBuilder = new DamageHeroBuilder();
                dmgBuilder.buildHeroID();
                dmgBuilder.buildHeroName(name);
                dmgBuilder.buildHeroAttack();
                dmgBuilder.buildHeroClass();
                dmgBuilder.buildHeroDefense();
                dmgBuilder.buildHeroExperience();
                dmgBuilder.buildHeroHitPoints();
                dmgBuilder.buildHeroLevel();
                newCharacter = dmgBuilder.getHero();
                return (newCharacter);
            
            case TANK:
                TankHeroBuilder tankBuidler = new TankHeroBuilder();
                tankBuidler.buildHeroID();
                tankBuidler.buildHeroName(name);
                tankBuidler.buildHeroAttack();
                tankBuidler.buildHeroClass();
                tankBuidler.buildHeroDefense();
                tankBuidler.buildHeroExperience();
                tankBuidler.buildHeroHitPoints();
                tankBuidler.buildHeroLevel();
                newCharacter = tankBuidler.getHero();
                return (newCharacter);
            
            default:
                throw new Exception("ERROR: Invalid character type");
        }
    }
}