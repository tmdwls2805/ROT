package com.hoseo.rot.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;
	
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
