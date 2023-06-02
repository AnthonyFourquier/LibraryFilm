package fr.eni.movielibrary.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dao.MovieDAO;

@Component
@Profile("jpa")
public class MovieDAOJPAImpl implements MovieDAO {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public Movie findById(long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		return movie.get();
	}

	@Override
	public List<Movie> findByAll() {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		return movies;
	}

	@Override
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	@Override
	public void save(Movie movie) {
		movieRepository.save(movie);
	}
	
	
}
