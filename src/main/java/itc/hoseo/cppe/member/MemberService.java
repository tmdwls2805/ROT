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


    public boolean isValidUser(String id, String passwd) {
    	Member m = new Member();
    	m.setId(id);
    	m.setPassword(passwd);
    	return memberRepository.getMember(m) != null;
    }
    
    /*모든 멤버 불러오기*/
    public List<Member> getAllMembers(){
    	return memberRepository.getAllMemebers();
    }
    
    
    
    public String getName(String id) {
    	return memberRepository.getName(id);  
    }
}
