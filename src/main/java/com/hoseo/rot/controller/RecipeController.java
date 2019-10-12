package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hoseo.rot.member.Member;
import com.hoseo.rot.recipe.Recipe;
import com.hoseo.rot.recipe.RecipeService;


@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	
	  @GetMapping("/recipeEnroll") 
	  public String recipeEnroll() 
	  { 
		  return "recipe/recipeEnroll"; 
		  }
	  
	  @PostMapping("/recipeEnroll") 
	  public String enroll(Recipe r) 
	  {
	  if(recipeService.addRecipe(r)){
		  return "redirect:/";
	  } 
	  return "recipe/recipeEnroll"; 
	  }
	    

}
