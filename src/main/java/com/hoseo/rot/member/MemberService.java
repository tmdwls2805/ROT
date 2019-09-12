package com.hoseo.rot.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoseo.rot.member.MemberRepository;
import com.hoseo.rot.member.Member;


@Service
public class MemberService{
	@Autowired
	private SqlSessionTemplate userSqlSession;
	private MemberRepository memberRepository;

	
	/*회원가입*/
    public int addMember(Member member) { 
        return memberRepository.addMemeber(member);
    }

    /*아이디 중복 체크*/
    public int idCheck(String id) {
    	memberRepository = userSqlSession.getMapper(MemberRepository.class);
    		return memberRepository.idCheck(id);
    }
}

