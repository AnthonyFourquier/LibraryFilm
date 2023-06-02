package fr.eni.movielibrary.dao;

import java.util.List;

import fr.eni.movielibrary.bo.Genre;

public interface GenreDAO {
	
	public Genre findById(long id);
	
	public List<Genre> findByAll();
	
	public void deleteMovie(Genre genre);
	
	public void save(Genre genre);
	
}
