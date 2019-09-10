package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoseo.rot.member.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "login/signUp";
	}
	
	@GetMapping("/signUp2")
	public String signUp2() {
		return "login/signUp2";
	}
}
