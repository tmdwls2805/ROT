package com.hoseo.rot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Autowired
   Environment env;

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		 * String uploadRecipeFolder=env.getProperty("rot.upload.recipe.path");
		 * registry.addResourceHandler("/upload/recipe/**").addResourceLocations(
		 * uploadRecipeFolder);
		 * 
		 * String uploadProductFolder=env.getProperty("rot.upload.product.path");
		 * registry.addResourceHandler("/upload/product/**").addResourceLocations(
		 * uploadProductFolder); }
		 */
	   
		String uploadUrl = env.getProperty("upload-product-path");  
		registry.addResourceHandler("/product/*.jpg")
		.addResourceLocations("file:///" + uploadUrl);
	}
}