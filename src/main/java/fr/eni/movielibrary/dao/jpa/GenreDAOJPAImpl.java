package fr.eni.movielibrary.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dao.GenreDAO;
import fr.eni.movielibrary.dao.MovieDAO;

@Component
@Profile("jpa")
public class GenreDAOJPAImpl implements GenreDAO {
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Override
	public Genre findById(long id) {
		Optional<Genre> genre = genreRepository.findById(id);
		return genre.get();
	}

	@Override
	public List<Genre> findByAll() {
		List<Genre> genres = (List<Genre>) genreRepository.findAll();
		return genres;
	}

	@Override
	public void deleteMovie(Genre genre) {
		genreRepository.delete(genre);
	}

	@Override
	public void save(Genre genre) {
		genreRepository.save(genre);
	}
	
	
}
