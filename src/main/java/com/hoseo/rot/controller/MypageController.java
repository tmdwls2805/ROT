package com.hoseo.rot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {
	
	@GetMapping("/recipeNote")
	public String recipeNote() {
		return "mypage/recipeNote";
	}

	@GetMapping("/MyHome")
	public String MyHome() {
		return "mypage/MyHome";
	}
	
	@GetMapping("/sidebar")
	public String sidebar() {
		return "mypage/sidebar";
	}

}
