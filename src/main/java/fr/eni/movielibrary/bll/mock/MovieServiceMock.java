package fr.eni.movielibrary.bll.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;

@Service
@Profile("dev")
public class MovieServiceMock implements fr.eni.movielibrary.bll.MovieService {
	// Attributs static pour gérer les valeurs à afficher
	private static List<Movie> lstMovies;
	private static List<Genre> lstGenres;
	private static List<Participant> lstParticipants;

	private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
			"Drame" };

	public MovieServiceMock() {
		// Création de la liste des genres
		lstGenres = new ArrayList<>();
		for (int index = 0; index < genres.length; index++) {
			lstGenres.add(new Genre(index + 1, genres[index]));
		}

		// Création de la liste des participants
		lstParticipants = new ArrayList<>();
		// 2 réalisateurs dont 1 pour 2 films
		Participant stevenSpielberg = new Participant(1, "Spielberg", "Steven");
		Participant davidCronenberg = new Participant(2, "Cronenberg", "David");
		lstParticipants.add(stevenSpielberg);
		lstParticipants.add(davidCronenberg);

		// 2 acteurs par film et l'un d'eux dans 2 films
		Participant richardAttenborough = new Participant(3, "Attenborough", "Richard");
		Participant jeffGoldblum = new Participant(4, "Goldblum", "Jeff");
		List<Participant> actorsJurassicPark = new ArrayList<>();
		actorsJurassicPark.add(richardAttenborough);
		actorsJurassicPark.add(jeffGoldblum);
		lstParticipants.addAll(actorsJurassicPark);

		Participant geenaDavis = new Participant(5, "Davis", "Geena");
		List<Participant> actorsTheFly = new ArrayList<>();
		actorsTheFly.add(jeffGoldblum);
		actorsTheFly.add(geenaDavis);
		lstParticipants.add(geenaDavis);

		Participant markRylance = new Participant(6, "Rylance", "Mark");
		Participant rubyBarnhill = new Participant(7, "Barnhill", "Ruby");
		List<Participant> actorsTheBFG = new ArrayList<>();
		actorsTheBFG.add(markRylance);
		actorsTheBFG.add(rubyBarnhill);
		lstParticipants.addAll(actorsTheBFG);

		// Création de la liste de films
		// 3 films
		lstMovies = new ArrayList<>();
		Movie jurassicPark = new Movie(1, "Jurassic Park", 1993, 128,
				"Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
		jurassicPark.setGenre(lstGenres.get(1));
		jurassicPark.setDirector(stevenSpielberg);
		jurassicPark.setListActors(actorsJurassicPark);
		jurassicPark.setImage("https://play-lh.googleusercontent.com/PAaK7re0Mw6SWtz8kxVO6h_xgYmPidgTVpCrGEhQjiOYqFpyfua6IH3V0peKwvbx1Vs");
		jurassicPark.setImage2("https://i.pinimg.com/originals/24/0e/31/240e3151408a1f74d4373436d6620509.png");
		
		lstMovies.add(jurassicPark);

		Movie theFly = new Movie(2, "The Fly", 1986, 95,
				"Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
		theFly.setGenre(lstGenres.get(1));
		theFly.setDirector(davidCronenberg);
		theFly.setListActors(actorsTheFly);
		theFly.setImage("https://image.tmdb.org/t/p/original/8gZWMhJHRvaXdXsNhERtqNHYpH3.jpg");
		theFly.setImage2("https://www.screamerscostumes.com/app/uploads/2021/10/26906-the-fly.png");
		lstMovies.add(theFly);

		Movie theBFG = new Movie(3, "The BFG", 2016, 117,
				"Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
		theBFG.setGenre(lstGenres.get(4));
		theBFG.setDirector(stevenSpielberg);
		theBFG.setListActors(actorsTheBFG);
		theBFG.setImage("https://assets-in.bmscdn.com/iedb/movies/images/mobile/thumbnail/xlarge/the-bfg-(3d-telugu)-et00044439-17-04-2017-17-59-20.jpg");
		theBFG.setImage2("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/a504c732-2487-47cd-9380-d08f32a02454/da3uqgn-6aa3acda-1863-493b-835a-9e524a9718cd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2E1MDRjNzMyLTI0ODctNDdjZC05MzgwLWQwOGYzMmEwMjQ1NFwvZGEzdXFnbi02YWEzYWNkYS0xODYzLTQ5M2ItODM1YS05ZTUyNGE5NzE4Y2QucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.QNrU-nm4OTyTUaGrDnYQWrrM4oKDzm_ToT3ZZxaKJRs");
		
		lstMovies.add(theBFG);
	}

	@Override
	public List<Movie> getAllMovies() {
		return lstMovies;
	}

	@Override
	public Movie getMovieById(long id) {
		for (Movie movie : lstMovies) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Genre> getGenres() {
		return lstGenres;
	}

	@Override
	public List<Participant> getParticipants() {
		return lstParticipants;
	}

	@Override
	public Genre getGenreById(long id) {
		for (Genre genre : lstGenres) {
			if (genre.getId() == id) {
				return genre;
			}
		}
		return null;
	}

	@Override
	public Participant getParticipantById(long id) {
		for (Participant participant : lstParticipants) {
			if (participant.getId() == id) {
				return participant;
			}
		}
		return null;
	}

	@Override
	public void saveMovie(Movie movie) {
		lstMovies.add(movie);
	}
}
