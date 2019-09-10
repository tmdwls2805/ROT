package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoseo.rot.member.MemberService;

@Controller
public class ContactController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/contact")
	public String contact() {
		return "/contact";
	}
	
}