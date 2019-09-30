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
import com.hoseo.rot.recipe.RecipeOrder;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	/*
	 * @GetMapping("/recipeEnroll") public String recipeEnroll() { return
	 * "recipe/recipeEnroll"; }
	 * 
	 * @PostMapping("/recipeEnroll") public String enroll(Recipe r) {
	 * if(recipeService.addRecipe(r)){ return "/";
	 * 
	 * } return "recipe/recipeEnroll"; }
	 */
}
