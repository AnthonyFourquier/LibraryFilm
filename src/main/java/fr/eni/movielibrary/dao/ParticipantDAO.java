package fr.eni.movielibrary.dao;

import java.util.List;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Participant;

public interface ParticipantDAO {
	
	public Participant findById(long id);
	
	public List<Participant> findByAll();
	
	public void deleteMovie(Participant participant);
	
	public void save(Participant participant);
	
}
