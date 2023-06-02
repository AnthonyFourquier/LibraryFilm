package fr.eni.movielibrary.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
	
}
