package itc.hoseo.cppe.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	/*회원가입*/
    public int addMember(Member member) { 
        return memberRepository.addMemeber(member);
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
    
    /*아이디 찾기*/
    public Member getFindId(Member member) {
    	return memberRepository.getFindId(member);
    }
    
    public Member getFindPassword(Member member) {
    	return memberRepository.getFindPassword(member);
    }
    
    public int lostPasswordUpdate(Member member) {
    	return memberRepository.lostPasswordUpdate(member);
    }
    
    public String getName(String id) {
    	return memberRepository.getName(id);
    }
    public int idCheck(String id) {
    	return memberRepository.idCheck(id);
    }
    
    public Member getUser(String id) {
    	return memberRepository.getUser(id);
    }
    
    public int updateUser(String id, Member member) {
    	return memberRepository.updateUser(id,member);
    }
}
