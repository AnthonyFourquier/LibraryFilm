package fr.eni.movielibrary.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "participants")
public class Participant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lastName;
	private String firstName;
	
	@OneToMany(mappedBy = "director")
	private List<Movie> listDirectors;
	
	@ManyToMany(mappedBy = "listActors")
	private List<Movie> listActors;
	
	public Participant(long id, String lastName, String firstName,  List<Movie> listDirectors, List<Movie> listActors) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.listDirectors = listDirectors;
		this.listActors = listActors;
	}
	
	public Participant(long id, String lastName, String firstName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public Participant() {
	}


	public List<Movie> getListActors() {
		return listActors;
	}

	public void setListActors(List<Movie> listActors) {
		this.listActors = listActors;
	}

	public List<Movie> getListDirectors() {
		return listDirectors;
	}

	public void setListDirectors(List<Movie> listDirectors) {
		this.listDirectors = listDirectors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", listDirectors="
				+ listDirectors + ", listActors=" + listActors + "]";
	}
	
}
