package com.hoseo.rot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hoseo.rot.member.Member;
import com.hoseo.rot.member.MemberRepository;
import com.hoseo.rot.member.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSpringTest {

	@Autowired
	MemberService memberService;
	

	
	@Test
	public void test2() {

	}
}
