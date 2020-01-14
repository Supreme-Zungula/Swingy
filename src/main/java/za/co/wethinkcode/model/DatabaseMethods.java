package za.co.wethinkcode.model;

import java.sql.*;
import java.util.ArrayList;

import za.co.wethinkcode.factories.CharacterFactory;
import za.co.wethinkcode.characters.Hero;
import za.co.wethinkcode.enums.CharacterType;

public class DatabaseMethods {

	public void createDb() {
        DatabaseManager dbManager = new DatabaseManager();
        System.out.println("Creating database.");
		try{
			Connection conn = dbManager.connect();
			if (conn != null) {
				DatabaseMetaData dbMeta = conn.getMetaData();
				System.out.println("meta is " + dbMeta);
				System.out.println("database created");
            }
            else {
                System.out.println("ERROR: could not connect to SQL lite.");
            }
		} catch(SQLException e){
			System.out.println(e.getMessage() + "\nError: cannot create database");
			System.exit(0);
		}
	}

    public void createTable()
    {
        DatabaseManager dbManager = new DatabaseManager();

		String sql = "CREATE TABLE IF NOT EXISTS heroes (\n"
				+ "heroID INTEGER PRIMARY KEY,\n"
				+ "heroName TEXT NOT NULL UNIQUE ,\n"
				+ "heroClass TEXT NOT NULL ,\n"
				+ "heroLevel INTEGER NOT NULL ,\n"
				+ "heroExp INTEGER NOT NULL ,\n"
				+ "heroHP INTEGER NOT NULL ,\n"
				+ "heroAtk INTEGER NOT NULL ,\n"
				+ "heroDef INTEGER NOT NULL \n"
				+ " );";

		try {
            Connection conn = dbManager.connect();
            System.out.println("Connected to db");
		    Statement stmt = conn.createStatement();
			//create table
			stmt.executeUpdate(sql);
			System.out.println("table added");
        }
        catch (SQLException ex){
			System.out.println(ex.getMessage() + "\nError: cannot create table");
			System.exit(0);
		}
	}

	public void addHero(Hero hero) {

        DatabaseManager dbManager = new DatabaseManager();
        
		String sql = "INSERT INTO heroes (heroName, heroClass, heroLevel, heroExp, heroHP, heroAtk, heroDef) VALUES (?,?,?,?,?,?,?)";
		try{
            Connection conn = dbManager.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, hero.getHeroName());
				pstmt.setString(2, hero.getHeroClass());
				pstmt.setInt(3, hero.getHeroLevel());
				pstmt.setInt(4, hero.getHeroExperience());
				pstmt.setInt(5, hero.getHeroHitPoints());
				pstmt.setInt(6, hero.getHeroAttack());
				pstmt.setInt(7, hero.getHeroDefense());
				pstmt.execute();
				System.out.println("\nNew hero added to database");
		}catch (SQLException ex){
			System.out.println("\nError: Hero name '" + hero.getHeroName() + "' already in use");
		//	System.exit(0);
		}
	}

	public void showAll(){
        DatabaseManager dbManager = new DatabaseManager();

		String sql = "SELECT * FROM heroes";
		try{
            Connection conn = dbManager.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);

			System.out.println("These are all saved heroes");
			while(rs.next()){
				System.out.println( "\nID: " + rs.getInt("heroID" ) +
									"\nName: " + rs.getString("heroName") +
									"\nClass: " + rs.getString("heroClass") +
									"\nLevel: " + rs.getInt("heroLevel") +
									"\nExperience: " + rs.getInt("heroExp") +
									"\nHit Points: " + rs.getInt("heroHP") +
									"\nAttack: " + rs.getInt("HeroAtk") +
									"\nDefense: " + rs.getInt("HeroDef"));
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage() + "selection error");
		//	System.exit(0);
		}
	}
    
    public ArrayList<Hero> selectAll() {
        DatabaseManager dbManager = new DatabaseManager();
        ArrayList<Hero> heroesList = new ArrayList<>();

		String sql = "SELECT * FROM heroes";
		try{
            Connection conn = dbManager.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);

			System.out.println("These are all saved heroes");
			while(rs.next()) {
                Hero newHero = new Hero();
                newHero.setHeroID();
                newHero.setHeroName(rs.getString("heroName"));
                newHero.setHeroClass(rs.getString("heroClass"));
		        newHero.setHeroLevel(rs.getInt("heroLevel"));
				newHero.setHeroExperience(rs.getInt("heroExp"));
                newHero.setHeroHitPoints(rs.getInt("heroHP"));
				newHero.setHeroAttack(rs.getInt("HeroAtk"));
                newHero.setHeroDefense(rs.getInt("HeroDef"));
                heroesList.add(newHero);
            }
		}catch(SQLException ex){
            System.out.println(ex.getMessage() + "selection error");
            //	System.exit(0);
		}
        return (heroesList);
	}

	public void selectHero(String heroName) {
        DatabaseManager dbManager = new DatabaseManager();

		String sql = "SELECT * FROM heroes WHERE heroName = '" + heroName + "'";
		try{
            Connection conn = dbManager.connect();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println( "\nID: " + rs.getInt("heroID" ) +
									"\nName: " + rs.getString("heroName") +
									"\nClass: " + rs.getString("heroClass") +
									"\nLevel: " + rs.getInt("heroLevel") +
									"\nExperience: " + rs.getInt("heroExp") +
									"\nHit Points: " + rs.getInt("heroHP") +
									"\nAttack: " + rs.getInt("HeroAtk") +
									"\nDefense: " + rs.getInt("HeroDef"));
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage() + "\nError: Hero Does not exist");
		//	System.exit(0);
		}
	}

    public Hero getHeroFromDB(String name) {
		int heroLvl, heroExp, heroHP, heroAtk, heroDef;
		String heroName, heroClass;
		CharacterFactory characterFactory = new CharacterFactory();
		Hero hero= null;

        DatabaseManager dbManager = new DatabaseManager();

		String sql = "SELECT * FROM heroes WHERE heroName = '" + name + "'";
		
		try{
            Connection conn = dbManager.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
				heroName = rs.getString("heroName");
				heroClass = rs.getString("heroClass");
				heroLvl = rs.getInt("heroLevel");
				heroExp = rs.getInt("heroExp");
				heroHP = rs.getInt("heroHP");
				heroAtk = rs.getInt("heroAtk");
				heroDef = rs.getInt("heroDef");
            
                try {
                    switch(heroClass.toLowerCase()){
                        case "tank":
                            hero = characterFactory.createCharacter(CharacterType.TANK, heroName);
                            break;
                        case "flank":
                            hero = characterFactory.createCharacter(CharacterType.FLANK, heroName);
                            break;
                        case "damage":
                            hero = characterFactory.createCharacter(CharacterType.DAMAGE, heroName);
                            break;
                    }
                } catch (Exception ex){
                    System.out.println("ERROR: could not create character.\n" + ex.getMessage());
                }
            } 
            return hero;
        }catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}
	

	public void updateHero(Hero hero) {
        DatabaseManager dbManager = new DatabaseManager();
    
		String sql = "UPDATE heroes SET heroLevel = ?," +
				"heroExp = ?," +
				"heroHP = ?," +
				"HeroAtk = ?," +
				"heroDef = ?" +
				"WHERE heroName = ?";
		try{
            Connection conn = dbManager.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//set Parameters
			pstmt.setInt(1, hero.getHeroLevel());
			pstmt.setInt(2,hero.getHeroExperience());
			pstmt.setInt(3, hero.getHeroHitPoints());
			pstmt.setInt(4, hero.getHeroAttack());
			pstmt.setInt(5, hero.getHeroDefense());
			pstmt.setString(6,hero.getHeroName());
			//update Hero stats
			pstmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println(ex.getMessage());
        }
    }

    public void deleteHero(String heroName) 
    {
        DatabaseManager dbManager = new DatabaseManager();

		String sql = "DELETE * FROM heroes WHERE heroName = ?";
		try{
            Connection conn = dbManager.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,heroName);
			pstmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println("Error: cannot delete hero");
        }
    }
}