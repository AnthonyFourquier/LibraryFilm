package fr.eni.movielibrary.bo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bll.ParticipantService;
import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Participant;

@Component
public class ParticipantConverter implements Converter<String, Participant> {
	
	@Autowired
	ParticipantService participantService;

	@Override
	public Participant convert(String id) {
		return participantService.getParticipant(Integer.parseInt(id));
	}



}
