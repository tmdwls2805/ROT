package itc.hoseo.cppe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import itc.hoseo.cppe.member.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
//로그인화면으로 이동
	@RequestMapping(value = "loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping("/loginForm")
	public String login() {
		return "login/loginForm";
	}

//회원가입 동의로 이동
	@GetMapping("/signUp")
	public String signUp1() {
		return "login/signUp";
	}

//회원가입 작성으로 이동
	@RequestMapping(value = "signUp2", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping("/signUp2")
	public String signUp2() {
		return "login/signUp2";
	}

//회원가입 동의로 이동
	@GetMapping("/findIdPw")
	public String findIdPw() {
		return "login/findIdPw";
	}

// 아이디 찾기로 이동
	@GetMapping("/findId")
	public String findId() {
		return "login/findId";
	}

// 비밀번호 찾기로 이동
	@GetMapping("/findPassword")
	public String findPassword() {
		return "login/findPassword";
	}

// 아이디 완료로 이동
	@RequestMapping(value = "findIdProc", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping("/findIdProc")
	public String findIdProc() {
		return "login/findIdProc";
	}

// 비밀번호 정보 입력으로 이동
	@RequestMapping(value = "findPasswordProc", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping("/findPasswordProc")
	public String findPasswordProc() {
		return "login/findPasswordProc";
	}

// 비밀번호 찾기 완료로 이동
	@RequestMapping(value = "findRePasswordProc", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping("/findRePasswordProc")
	public String findRePasswordProc() {
		return "login/findRePasswordProc";
	}

}
