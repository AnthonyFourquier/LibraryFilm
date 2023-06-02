package fr.eni.movielibrary.dao;

import java.util.List;

import fr.eni.movielibrary.bo.Member;

public interface MemberDAO {
	
	public Member findById(long id);
	
	public List<Member> findByAll();
	
	public void deleteMember(Member member);
	
	public void save(Member member);
	
}
