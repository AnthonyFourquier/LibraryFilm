package fr.eni.movielibrary.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private int year;
	private int duration;
	private String synopsis;
	
	@ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
	private Participant director;
	
	@ManyToMany
	@JoinTable(
	name = "actors",
	joinColumns = @JoinColumn(name = "participant_id"),
	inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Participant> listActors;
	
	@OneToMany(mappedBy = "movie")
	private List<Opinion> listOpinions;
	
	@ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
	private Genre genre;
	
	private String image;
	private String image2;
	
	public Movie(long id, String title, int year, int duration, String synopsis, Participant director, List<Participant> listActors, List<Opinion> listOpinions, Genre genre, String image, String image2) {
		this.id =id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.synopsis = synopsis;
		this.director = director;
		this.listActors = listActors;
		this.listOpinions = listOpinions;
		this.genre = genre;
		this.image = image;
		this.image2 = image2;
	}

	public Movie(long id, String title, int year, int duration, String synopsis) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.synopsis = synopsis;
	}
	
	public Movie(String title, int year, int duration, String synopsis) {
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.synopsis = synopsis;
	}
	
	public Movie(long id, String title, int year, int duration, String synopsis, Participant director) {
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.synopsis = synopsis;
		this.director = director;
	}
	
	public Movie() {
		
	}
	
	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Opinion> getListOpinions() {
		return listOpinions;
	}

	public void setListOpinions(List<Opinion> listOpinions) {
		this.listOpinions = listOpinions;
	}

	public List<Participant> getListActors() {
		return listActors;
	}
	
	public void setListActors(List<Participant> listActors) {
		this.listActors = listActors;
	}

	public Participant getDirector() {
		return director;
	}

	public void setDirector(Participant director) {
		this.director = director;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}


	
}
