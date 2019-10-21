package com.hoseo.rot.member;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService{
	@Autowired
	private MemberRepository memberRepository;
	Logger log = LoggerFactory.getLogger(MemberService.class);
	
	
	/*회원가입*/
    public boolean addMember(Member member) { 
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
		return memberRepository.addMember(member)==1;
    }

    /*아이디 중복 체크*/
    public int idCheck(String id) {
    	return memberRepository.idCheck(id);
    }
    
    /*이메일 중복 체크*/
    public int emailCheck(String email) {
    	return memberRepository.emailCheck(email);
    }
 
    /*닉네임 중복 체크*/
    public int nicknameCheck(String nickname) {
    	return memberRepository.nicknameCheck(nickname);
    }    
    
    /*로그인*/
    public boolean isValidUser(Member m) {
    	return memberRepository.getMember(m) != null;
    }
    
    
    /*회원정보 가져오기*/
    public Member getMember(Member member) { 
        return memberRepository.getMember(member);
    }
    
    /*회원가입완료한 회원 정보 가져오기*/
    public Member getUser(Member m) {
    	return memberRepository.getUser(m);
    }
    
    /*비밀번호 암호화*/
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
	
	/* 아이디 찾기 */
    public Member findId(Member m) {
    	return memberRepository.findId(m);
    }
    
}

