package com.hoseo.rot.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoseo.rot.member.MemberService;
import com.hoseo.rot.member.Member;


@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;

	// 로그인
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
	
	// 약관동의
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}
	

	// 회원가입 페이지로 이동
	@RequestMapping(value = "signUp2", method = { RequestMethod.GET, RequestMethod.POST })
	public String signUp2() {
		return "login/signUp2";
	}
	
	// 회원가입 완료
	@RequestMapping(value = "/signUp2/sign", method = { RequestMethod.GET, RequestMethod.POST })
	public String sign(Member m) {
		if (memberService.addMember(m) == 1) {
			return "redirect:/signUpComplete";
		} else {
			return "login/signup2";
		}
	}
	
	@GetMapping("/signUpComplete")
	public String signUpComplete() {
		return"login/signUpComplete";
	}
	
	@GetMapping("/test")
	public String test() {
		return"/test";
	}
}
