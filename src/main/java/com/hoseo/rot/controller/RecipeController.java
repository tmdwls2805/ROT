package com.hoseo.rot.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hoseo.rot.recipe.RecipeService;
import com.hoseo.rot.recipe.Recipe;


@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	

	// 회원가입 완료
	@GetMapping("/recipeEnroll")
	public String recipeEnroll() {
		return"recipe/recipeEnroll";
	}


}
