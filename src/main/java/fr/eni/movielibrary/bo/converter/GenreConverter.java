package fr.eni.movielibrary.bo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bll.GenreService;
import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Genre;

@Component
public class GenreConverter implements Converter<String, Genre> {
	
	@Autowired
	GenreService genreService;

	@Override
	public Genre convert(String id) {
		return genreService.getGenre(Integer.parseInt(id));
	}

}
