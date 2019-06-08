package itc.hoseo.cppe.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	/*회원가입*/
    public boolean addMember(Member member) { 
        return memberRepository.addMemeber(member) == 1;
    }
    
    public Member getMember(Member member) { 
        return memberRepository.getMember(member);
    }


    public boolean isValidUser(Member m) {
    	return memberRepository.getMember(m) != null;
    }
    
    /*모든 멤버 불러오기*/
    public List<Member> getAllMembers(){
    	return memberRepository.getAllMemebers();
    }
    
    /*아이디에 맞는 이름찾아오기*/
    public String getName(String id) {
    	return memberRepository.getName(id);  
    }
    
    /*아이디 찾기*/
    public boolean getFindId(Member member) {
    	return memberRepository.getFindId(member) != null;
    }
    
    public boolean getFindPassword(Member member) {
    	return memberRepository.getFindPassword(member) != null;
    }
    
    public int idCheck(String id) {
    	return memberRepository.idCheck(id);
    }
}
