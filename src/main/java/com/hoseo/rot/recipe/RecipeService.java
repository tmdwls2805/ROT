package com.hoseo.rot.recipe;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
	

    
}

