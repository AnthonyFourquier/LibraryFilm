package fr.eni.movielibrary.bo;

import java.util.List;

public class Movie {
	private long id;
	private String title;
	private int year;
	private int duration;
	private String synopsis;
	private Participant director;
	private List<Participant> listActors;
	private List<Opinion> listOpinions;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", duration=" + duration + ", synopsis="
				+ synopsis + ", director=" + director + ", listActors=" + listActors + ", listOpinions=" + listOpinions
				+ ", genre=" + genre + "]";
	}
	
}
