package basics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//the class is an entity
@Entity // This tells Hibernate to make a table out of this class
public class User {

	//primary key of an entity
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //generation strategies configuration -> AUTO Gen
    private Integer id;

    private String name;

    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}