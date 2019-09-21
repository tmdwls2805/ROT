package com.hoseo.rot.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hoseo.rot.member.MemberService;
import com.hoseo.rot.member.Member;


@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	// 회원가입 페이지로 이동
	@PostMapping("/signUp2")
	public String signUp2() {
		return "login/signUp2";
	}
	
	// 회원가입 완료
	@PostMapping("/signUp2/sign")
	public String sign(Member m, HttpSession session) {
		if (memberService.addMember(m) == 1) {
			Member member = memberService.getUser(m);
			session.setAttribute("member", member);
			session.setAttribute("id", member.getId());
			return "redirect:/signUpComplete";
		} else {
			return "login/signup2";
		}
	}
	
	// 로그인
	@GetMapping("/loginForm")
	public String login() {
		return "login/loginForm";
	}
	
	// 로그인 완료
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
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("/logout2")
	public String logout2(HttpSession session) {
		session.invalidate();
		return "redirect:/loginForm";
	}
	
	// 약관동의
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}

	// 회원가입 완료
	@GetMapping("/signUpComplete")
	public String signUpComplete() {
		return"login/signUpComplete";
	}
	
	
	@GetMapping("/test")
	public String test() {
		return"/test";
	}
}
