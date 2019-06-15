package itc.hoseo.cppe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import itc.hoseo.cppe.member.Member;
import itc.hoseo.cppe.member.MemberRepository;
import itc.hoseo.cppe.member.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSpringTest {

	@Autowired
	MemberService memberService;
	

	
	@Test
	public void test2() {
		Member mem=new Member();
		mem.setName("박승진");
		mem.setEmail1("qkrtmdwls280");
		mem.setEmail2("gmail.com");
		mem.setPh1(10);
		mem.setPh2(4070);
		mem.setPh3(2805);
		log.debug(memberService.getFindId(mem).getId());
	}
}
