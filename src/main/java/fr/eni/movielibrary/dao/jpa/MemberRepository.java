package fr.eni.movielibrary.dao.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import fr.eni.movielibrary.bo.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	Optional<Member> findByLoginEquals(String login);
	
}
