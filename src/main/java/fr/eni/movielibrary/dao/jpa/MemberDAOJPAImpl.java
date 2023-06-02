package fr.eni.movielibrary.dao.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dao.MemberDAO;
import fr.eni.movielibrary.dao.MovieDAO;

@Component
@Profile("jpa")
public class MemberDAOJPAImpl implements MemberDAO {
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	@Override
	public Member findById(long id) {
		Optional<Member> member = memberRepository.findById(id);
		return member.get();
	}

	@Override
	public List<Member> findByAll() {
		List<Member> members = (List<Member>) memberRepository.findAll();
		return members;
	}

	@Override
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}

	@Override
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	
}
