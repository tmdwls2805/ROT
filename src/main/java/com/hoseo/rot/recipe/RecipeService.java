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
	
	public boolean updateRecipe(Recipe r) {
		return recipeRepository.updateRecipe(r)==1;
	}
	
	public boolean updateRecipeOrder(RecipeOrder ro) {
		return recipeRepository.updateRecipeOrder(ro)==1;
	}
	
	public boolean updateMaterial(Material m) {
		return recipeRepository.updateMaterial(m)==1;
	}
	
	public boolean updateMaterial2(Material2 m2) {
		return recipeRepository.updateMaterial2(m2)==1;
	}
	
	public boolean deleteRecipe(Recipe r) {
		return recipeRepository.deleteRecipe(r)==1;
	}
	    
  public List<Recipe> getRecipeList() {
	  return recipeRepository.getRecipeList();
  }
  public Recipe getRecipe(Recipe r) {
	  return recipeRepository.getRecipe(r);
  }
  public List<RecipeOrder> getRecipeOrder(int reciInputNum) {
	  return recipeRepository.getRecipeOrder(reciInputNum);
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
  
  
  public List<Material> getMaterial(int reciInputNum) {
	  return recipeRepository.getMaterial(reciInputNum);
  }
  public List<Material2> getMaterial2(int reciInputNum) {
	  return recipeRepository.getMaterial2(reciInputNum);
  }	  	  

}
