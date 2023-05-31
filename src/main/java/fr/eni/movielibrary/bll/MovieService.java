package fr.eni.movielibrary.bll;

import java.util.List;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Opinion;
import fr.eni.movielibrary.bo.Participant;

public interface MovieService {

	List<Movie> getAllMovies();

	Movie getMovieById(long id);

	List<Genre> getGenres();

	List<Participant> getParticipants();

	Genre getGenreById(long id);

	Participant getParticipantById(long id);

	void saveMovie(Movie movie);
	
	void editMovie(Movie movie);
	
	void deleteMovie(Movie movie);

	void saveOpinion(Opinion opinion);
	
}
