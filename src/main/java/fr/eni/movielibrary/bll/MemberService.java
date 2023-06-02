package fr.eni.movielibrary.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Member;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;
import fr.eni.movielibrary.dao.jpa.GenreRepository;
import fr.eni.movielibrary.dao.jpa.MemberRepository;
import fr.eni.movielibrary.dao.jpa.MovieRepository;
import fr.eni.movielibrary.dao.jpa.ParticipantRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	public Optional<Member> getByLogin(String login) {
		return this.memberRepository.findByLoginEquals(login);
	}
	
	public Member getMember(long id) {
		Optional<Member> member = memberRepository.findById(id);
		return member.get();
	}
	
	public List<Member> getMembers() {
		List<Member> members = (List<Member>) memberRepository.findAll();
		return members;
	}
	
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}

}
