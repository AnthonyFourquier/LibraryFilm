package fr.eni.movielibrary.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String label;
	
	@OneToMany(mappedBy = "genre")
	private List<Movie> listMovie;
	
	public Genre(long id, String label, List<Movie> listMovie) {
		this.id = id;
		this.label = label;
		this.listMovie = listMovie;
	}
	
	public Genre() {
		
	}
	
	public Genre(long id, String label) {
		this.id = id;
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Movie> getListMovie() {
		return listMovie;
	}

	public void setListMovie(List<Movie> listMovie) {
		this.listMovie = listMovie;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", label=" + label + ", listMovie=" + listMovie + "]";
	}
	
}
