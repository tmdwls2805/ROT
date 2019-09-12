package com.hoseo.rot.member;

import org.apache.ibatis.annotations.Mapper;
import com.hoseo.rot.member.Member;

@Mapper
public interface MemberRepository {

	public int addMemeber(Member m); //회원가입
	
	public int idCheck(String id); // 아이디 중복 체크
	
}
