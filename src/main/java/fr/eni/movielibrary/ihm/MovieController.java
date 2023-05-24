package fr.eni.movielibrary.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("movies", movieServiceMock.getAllMovies());
        return "home";
    }
	
	@GetMapping("/detailMovie/{id}")
    public String detailMoviePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("movie", movieServiceMock.getMovieById(id));
        return "detailMovie";
    }
	
}
