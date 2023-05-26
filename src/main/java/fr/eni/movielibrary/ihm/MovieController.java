package fr.eni.movielibrary.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.movielibrary.bll.mock.MovieServiceMock;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;

@Controller
@SessionAttributes({"loggedUser"})
public class MovieController {
	
	@Autowired
	private MovieServiceMock movieServiceMock;
	
	@GetMapping("/")
    public String homePage(Model model) {
		
		if ( model.getAttribute("loggedUser") != null) {
			Member memberConnected = (Member) model.getAttribute("loggedUser");
			model.addAttribute("member", memberConnected);
		}
		
        model.addAttribute("movies", movieServiceMock.getAllMovies());
        
        return "home";
    }
	
	@GetMapping("/detailMovie/{id}")
    public String detailMoviePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("movie", movieServiceMock.getMovieById(id));
        return "detailMovie";
    }
	
	@GetMapping("/editMovie/{id}")
    public String editMoviePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("movie", movieServiceMock.getMovieById(id));
        return "editMovie";
    }
	
	@PostMapping("movie")
	public String personSubmit(@ModelAttribute("formMovie") Movie movie) {
		System.out.println(String.format("Movie : %s", movie.getTitle()));
		return "home";
	}
	
}
