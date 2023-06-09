package fr.eni.movielibrary.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dao.jpa.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public void save(Movie movie) {
		movieRepository.save(movie);
	}
	
	public Movie getMovie(long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		return movie.get();
	}
	
	public List<Movie> getMovies() {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		return movies;
	}
	
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}
	
}
