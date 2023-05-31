package fr.eni.movielibrary.bo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Participant;

@Component
public class ParticipantConverter implements Converter<String, Participant> {
	
	@Autowired
	MovieService movieService;

	@Override
	public Participant convert(String id) {
		return movieService.getParticipantById(Integer.parseInt(id));
	}



}
