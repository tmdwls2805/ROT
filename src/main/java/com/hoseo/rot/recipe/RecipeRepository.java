package com.hoseo.rot.recipe;


import org.apache.ibatis.annotations.Mapper;
import com.hoseo.rot.recipe.Recipe;

@Mapper
public interface RecipeRepository {

	public int addRecipe(Recipe r); 
	public int addRecipe(RecipeOrder ro);
	public int addRecipe(Material m);
	public int addRecipe(Material2 m2);
	
}
