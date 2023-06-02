package fr.eni.movielibrary.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dao.jpa.GenreRepository;
import fr.eni.movielibrary.dao.jpa.MovieRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public void save(Genre genre) {
		genreRepository.save(genre);
	}
	
	public Genre getGenre(long id) {
		Optional<Genre> genre = genreRepository.findById(id);
		return genre.get();
	}
	
	public List<Genre> getGenres() {
		List<Genre> genres = (List<Genre>) genreRepository.findAll();
		return genres;
	}
	
	public void deleteGenre(Genre genre) {
		genreRepository.delete(genre);
	}
	
}
