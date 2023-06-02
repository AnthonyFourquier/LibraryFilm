package fr.eni.movielibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.movielibrary.bll.GenreService;
import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bll.ParticipantService;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Opinion;

@Controller
@SessionAttributes({"loggedUser"})
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("/")
    public String homePage(Model model) {
		
		if ( model.getAttribute("loggedUser") != null) {
			Member memberConnected = (Member) model.getAttribute("loggedUser");
			model.addAttribute("member", memberConnected);
		}
		
        model.addAttribute("movies", movieService.getMovies());
        
        return "home";
    }
	
	@GetMapping("/detailMovie/{id}")
    public String detailMoviePage(Model model, @PathVariable("id") int id) {
		model.addAttribute("movie", movieService.getMovie(id));
		model.addAttribute("opinion", new Opinion());
        return "detailMovie";
    }
	
	@GetMapping("/editMovie/{id}")
    public String editMoviePage(Model model, @PathVariable("id") int id) {
		if (model.getAttribute("loggedUser") != null) {
			Movie movie =  movieService.getMovie(id);
			model.addAttribute("movie", movie);
			model.addAttribute("genreOption", genreService.getGenres());
			model.addAttribute("directorOption", participantService.getParticipants());
	        return "editMovie";
		} else {
			return "redirect:/";
		}
		
    }
	
	@PostMapping("/movieEdit")
	public String movieEditSubmit(@ModelAttribute("formMovie") Movie movie, Model model) {
		movieService.save(movie);
		return "redirect:/";
	}
	
	@GetMapping("/addMovie")
    public String movieAddPage(Model model) {
		if (model.getAttribute("loggedUser") != null) {
			model.addAttribute("movie", new Movie());
			model.addAttribute("genreOption", genreService.getGenres());
			model.addAttribute("directorOption", participantService.getParticipants());
			return "addMovie";
		} else {
	        return "redirect:/";
		}
    }
	
	@PostMapping("/movieAdd")
	public String movieAddSubmit(@ModelAttribute("formMovie") Movie movie, Model model) {
		movieService.save(movie);
		return "redirect:/";
	}
	
	@GetMapping("/movieRemove/{id}")
	public String movieRemoveSubmit(Model model, @PathVariable("id") int id) {
		Movie movie = movieService.getMovie(id);
		movieService.deleteMovie(movie);
		return "redirect:/";
	}
	
	@PostMapping("/addOpinion")
	public String opinionAddSubmit(@ModelAttribute("formOpinion") Opinion opinion, Movie movie) {
		opinion.setId(movie.getId());
		opinion.setMovie(movie);
//		movieServiceMock.saveOpinion(opinion);
		System.out.println(opinion.getMovie().getId());
		return "redirect:/";
	}
	
}
