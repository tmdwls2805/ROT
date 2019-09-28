package com.hoseo.rot.member;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoseo.rot.member.MemberRepository;
import com.hoseo.rot.member.Member;


@Service
public class MemberService{
	@Autowired
	private MemberRepository memberRepository;
	Logger log = LoggerFactory.getLogger(MemberService.class);
	
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
    
	public Member encryp(Member member) {
		MessageDigest digest;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException nae) {
			log.error("암호화 알고리즘 초기화 에러",nae);
			throw new RuntimeException(nae);
		}
		
		digest.update(member.getPassword().getBytes());
		StringBuilder sb = new StringBuilder();
		for(byte b: digest.digest()) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}		
		member.setPassword(sb.toString()); 
		
		return member; 
	}
    
}

