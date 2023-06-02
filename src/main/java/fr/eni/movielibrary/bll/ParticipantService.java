package fr.eni.movielibrary.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;
import fr.eni.movielibrary.dao.jpa.GenreRepository;
import fr.eni.movielibrary.dao.jpa.MovieRepository;
import fr.eni.movielibrary.dao.jpa.ParticipantRepository;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	public void save(Participant participant) {
		participantRepository.save(participant);
	}
	
	public Participant getParticipant(long id) {
		Optional<Participant> participant = participantRepository.findById(id);
		return participant.get();
	}
	
	public List<Participant> getParticipants() {
		List<Participant> participants = (List<Participant>) participantRepository.findAll();
		return participants;
	}
	
	public void deleteParticipant(Participant participant) {
		participantRepository.delete(participant);
	}
	
}
