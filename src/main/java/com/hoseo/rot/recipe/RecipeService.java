package com.hoseo.rot.recipe;

import java.util.List;

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
	  
	  
	  public List<Recipe> getRecipeList() {
		  return recipeRepository.getRecipeList();
	  }
	  public Recipe getRecipe(Recipe r) {
		  return recipeRepository.getRecipe(r);
	  }
	  public RecipeOrder getRecipeOrder(RecipeOrder ro) {
		  return recipeRepository.getRecipeOrder(ro);
	  }	  
	  public Material getMaterial(Material m) {
		  return recipeRepository.getMaterial(m);
	  }
	  public Material2 getMaterial2(Material2 m2) {
		  return recipeRepository.getMaterial2(m2);
	  }	  
	  public int getRecipeCount() {
		  return recipeRepository.getRecipeCount();
	  }
	  public List<Recipe> getRecipeUser(String reciId) {
		  return recipeRepository.getRecipeUser(reciId);
	  }
	  
	  public int getRecipeUserCount(String reciId) {
		  return recipeRepository.getRecipeUserCount(reciId);
	  }

}
