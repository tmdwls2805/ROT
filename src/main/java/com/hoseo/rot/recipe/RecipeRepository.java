package com.hoseo.rot.recipe;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface RecipeRepository {
	
	public int addRecipe(Recipe r);
	public int addRecipeOrder(RecipeOrder ro);
	public int addMaterial(Material m);
	public int addMaterial2(Material2 m2);
	public Recipe getRecipe(Recipe r);
	public List<RecipeOrder> getRecipeOrder(int reciInputNum);
	public List<Recipe> getRecipeList();
	public int getRecipeCount();
	public List<Recipe> getRecipeUser(String reciId);
	public int getRecipeUserCount(String reciId);
	
	public List<Material> getMaterial(int reciInputNum);
	public List<Material2> getMaterial2(int reciInputNum);		
}
