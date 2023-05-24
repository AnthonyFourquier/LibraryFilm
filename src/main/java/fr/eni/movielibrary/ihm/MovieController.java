package fr.eni.movielibrary.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.eni.movielibrary.bll.mock.MovieServiceMock;
import fr.eni.movielibrary.bo.Movie;

@Controller("movieBean")
public class MovieController {
	
	@Autowired
	private MovieServiceMock movieServiceMock;
	
	public Movie findMovie(int i) {
		// TODO Auto-generated method stub
		return movieServiceMock.getMovieById(i);
	}
	
	public List<Movie> showAllMovies() {
		// TODO Auto-generated method stub
		return movieServiceMock.getAllMovies();
	}

}
