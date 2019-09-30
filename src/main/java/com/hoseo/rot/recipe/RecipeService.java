package com.hoseo.rot.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoseo.rot.recipe.RecipeRepository;
import com.hoseo.rot.recipe.Recipe;


@Service
public class RecipeService{
	@Autowired
	private RecipeRepository recipeRepository;
	
	Logger log = LoggerFactory.getLogger(RecipeService.class);
	
	public boolean addRecipe(Recipe r) {
		return recipeRepository.addRecipe(r)==1;
	}
    
	public boolean addRecipeOrder(RecipeOrder ro) {
		return recipeRepository.addRecipeOrder(ro)==1;
	}
	
	public boolean addMaterial(Material m) {
		return recipeRepository.addMaterial(m)==1;
	}
	
	public boolean addMaterial2(Material2 m2) {
		return recipeRepository.addMaterial2(m2)==1;
	}
}

