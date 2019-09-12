package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "signUp2", method = { RequestMethod.GET, RequestMethod.POST })
	public String signUp2() {
		return "login/signUp2";
	}
	
	@GetMapping("/test")
	public String test() {
		return"/test";
	}
}
