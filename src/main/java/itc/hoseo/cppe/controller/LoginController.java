package itc.hoseo.cppe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import itc.hoseo.cppe.member.Member;
import itc.hoseo.cppe.member.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;

//로그인화면으로 이동
	// @RequestMapping(value = "loginForm", method = { RequestMethod.GET,
	// RequestMethod.POST })
	@GetMapping("/loginForm")
	public String login() {
		return "login/loginForm";
	}

	@PostMapping("/loginForm")
	public String login(Member m, HttpSession session) {
		if (memberService.isValidUser(m) == false) {
			return "login/loginForm";
		}
		Member member = memberService.getMember(m);
		session.setAttribute("member", member);
		session.setAttribute("id", member.getId());
		return "redirect:index";
	}

	@GetMapping("/logout")
	public String signUp1(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

//회원가입 동의로 이동
	@GetMapping("/signUp")
	public String signUp1() {
		return "login/signUp";
	}

//회원가입
	@PostMapping("/signUp2")
	public String signUp2() {
		return "login/signUp2";
	}

	@RequestMapping(value = "/signUp2/sign", method = { RequestMethod.GET, RequestMethod.POST })
	public String sign(Member m) {
		if (memberService.addMember(m) == 1) {
			return "redirect:/";
		} else {
			return "login/signup2";
		}
	}
	
	// 아이디/비밀버호 찾기 정하는 페이지
		@GetMapping("/findIdPw")
		public String findIdPw() {
			return "login/findIdPw";
		}
		
	// 아이디 중복체크
	@GetMapping("/idCheck/{id}")
	public void idCheck(@PathVariable String id, HttpServletResponse response) throws IOException {
		int ret = memberService.idCheck(id);
		if (ret == 0)
			response.getWriter().println("ID is available.");
		else
			response.getWriter().println("Duplicate ID.");
	}

// 아이디 찾기로 이동
	@GetMapping("/findId")
	public String findId() {
		return "login/findId";
	}

// 아이디 찾기 완료로 이동
	@RequestMapping(value ="/findIdProc" ,method = { RequestMethod.GET, RequestMethod.POST })
	public String findIdProc(Member mem,ModelMap model) {
		Member getId=memberService.getFindId(mem);
		if (getId == null){
			return "/login/findId";
		}else {
			model.put("memId",getId.getId() );
			return "/login/findIdProc";
		}
	}

// 비밀번호 찾기로 이동
	@GetMapping("/findPassword")
	public String findPassword() {
		return "login/findPassword";
	}

// 비밀번호 정보 입력으로 이동
	@RequestMapping(value = "/findPasswordProc", method = { RequestMethod.GET, RequestMethod.POST })
	public String findPasswordProc(Member mem,ModelMap model) {
		Member getId=memberService.getFindPassword(mem);
		if(getId==null) {
			return "login/findPassword";
		}else {
			model.put("memId",getId.getId());
			return "login/findPasswordProc";
		}
	}
	
// 비밀번호 변경 완료
	@RequestMapping(value = "/findPasswordProc/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String findPasswordProc1(Member m) {
		if (memberService.lostPasswordUpdate(m)==1) {
			return "redirect:/";
		} else {
			return "login/findPasswordProc";
		}
	}
	
	

}
