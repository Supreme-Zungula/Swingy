package za.co.wethinkcode.characters;

import javax.persistence.*;
import javax.swing.text.Position;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import java.io.Serializable;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Default;
import za.co.wethinkcode.model.Coordinates;;

@Entity
@Table(name = "heroes")

public class Hero implements Serializable{

	private static final long 		serialVersionUID = 1L;
	/* Hero ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="heroID")
    private  Integer heroID;

	private static Integer idCounter = 0;
	
	/* Hero name */
	@Getter
	@Setter
	@NotNull
	@Size(min = 3, max = 10, message = "About Me must be between 3 and 10 characters")
	@NotBlank(message = "You cannot have a blank hero name")
	private String					heroName;
	
	/* Hero class */
	@Getter
	@Setter
	@NotNull
	@NotBlank(message = "Hero class Should not be blank")
	private String					heroClass;
	
	/* Hero Level */
	@Getter
	@Setter
	@Range(min = 1, max = 100)
	private int						heroLevel = 1;
	
	/* Hero experience */
	@Getter
	@Setter
	@Range(min = 1, max = 100)
	private int						heroExperience;
	
	/* Hero attack power */
	@Getter
	@Setter                                                                                                             
	@Range(min = 100, max = 1500)
	private int						heroAttack;
	
	/* Hero defence or shield */
	@Getter
	@Setter
	@Range(min = 500, max =  1000)
	private int						heroDefense;
	
	/* Hero hit points or Health pointe */
	@Getter
	@Setter
	@Range(min =  2000, max = 5000)
	private int						heroHitPoints;

	/* Hero's position on the map */
	@Getter
	@Setter
	Coordinates position;
	/**
	 * sets heroID to the private static idCounter
	 */
	public void setHeroID() 
	{
		this.heroID = ++idCounter;
	}
	
	public Integer getHeroID()
	{
		return (this.heroID);
	}

	@Override
	public String toString() {
		String details = "ID: " + this.getHeroID() +
						"\nName: " + this.getHeroName() +
						"\nClass: " +  this.getHeroClass() + 
						"\nLevel: " +  this.getHeroLevel() + 
						"\nExperience: " + this.getHeroExperience() + 
						"\nAttack: " + this.getHeroAttack() + 
						"\nDefense: " +  this.getHeroDefense() + 
						"\nHit points: " +  this.getHeroHitPoints();

		return (details);
	}
}