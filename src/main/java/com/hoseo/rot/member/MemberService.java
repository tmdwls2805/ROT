package com.hoseo.rot.member;

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
        return memberRepository.addMemeber(member);
    }

    public int idCheck(String id) {
    	return memberRepository.idCheck(id);
    }
}

