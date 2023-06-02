package fr.eni.movielibrary.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import fr.eni.movielibrary.bo.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	
}
