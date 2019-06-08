package itc.hoseo.cppe.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	public Member getMember(Member m);

	public List<Member> getAllMemebers();

	public int addMemeber(Member m);

	public int deleteMemeber(String id);

	public int updateMemeber(Member m);

	public int getCount(Member m);

	public String getName(String id);

	public Member getFindId(Member m);

	public Member getFindPassword(Member m);

	public Member lostPasswordUpdate(Member m);
	
	public int idCheck(String id);
}
