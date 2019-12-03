package za.co.wethinkcode.heroes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "heroes")
@Getter
@Setter
public class Hero implements Serializable{

	private static final long 		serialVersionUID = 1L;
	/* Hero ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="heroID")
    private Integer heroID;

	/* Hero name */
	@NotNull
	@NonNull
	@Size(min = 3, max = 10, message = "About Me must be between 3 and 10 characters")
	@NotBlank(message = "You cannot have a blank hero name")
	private String					heroName;
	
	/* Hero class */
	@NotNull
	@NotBlank(message = "Hero class Should not be blank")
	private String					heroClass;
	
	/* Hero Level */
	@Range(min = 1, max = 100)
	private int						heroLevel;
	
	/* Hero experience */
	@Range(min = 1, max = 100)
	private int						heroExperience;
	
	/* Hero attack power */
	@Range(min = 100, max = 1500)
	private int						heroAttack;
	
	/* Hero defence or shield */
	@Range(min = 500, max =  1000)
	private int						heroDefense;
	
	/* Hero hit points or Health pointe */
	@Range(min =  2000, max = 5000)
	private int						heroHitPoints;

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