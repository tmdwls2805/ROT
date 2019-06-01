package itc.hoseo.cppe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import itc.hoseo.cppe.member.MemberRepository;
import itc.hoseo.cppe.member.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisSpringTest {

	@Autowired
	MemberService memberService;
	
	@Test
	public void test() throws Exception{
		assertEquals("관리자" , memberService.getName("admin1"));
	}
}
