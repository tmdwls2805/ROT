package com.hoseo.rot.recipe;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface RecipeRepository {
	
	public int addRecipe(Recipe r);
	public int addRecipeOrder(RecipeOrder ro);
	public int addMaterial(Material m);
	public int addMaterial2(Material2 m2);

}
