package com.hoseo.rot.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoseo.rot.member.MemberRepository;
import com.hoseo.rot.member.Member;


@Service
public class MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	/*회원가입*/
    public int addMember(Member member) { 
        return memberRepository.addMember(member);
    }

    /*아이디 중복 체크*/
    public int idCheck(String id) {
    	return memberRepository.idCheck(id);
    }
    
    public int emailCheck(String email) {
    	return memberRepository.emailCheck(email);
    }
    
    public boolean isValidUser(Member m) {
    	return memberRepository.getMember(m) != null;
    }
    
    public Member getMember(Member member) { 
        return memberRepository.getMember(member);
    }
    
    public Member getUser(Member m) {
    	return memberRepository.getUser(m);
    }
    
}

