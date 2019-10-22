package com.hoseo.rot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	  
	  @Autowired
	  private Environment env;
	  
	  @PostMapping("/recipeEnroll") 
	  public String enroll(Recipe r, MultipartHttpServletRequest multi) {
			Iterator<String> imgs = multi.getFileNames();
			String path = env.getProperty("upload-img-path");
			String folderName1 = "recipe/"; 
	        File destinationFile = null;
	        MultipartFile mFile = null; 
	        
			while (imgs.hasNext()) {
				String uploadFile = imgs.next();			
				mFile = multi.getFile(uploadFile);
				String sourceFileName = mFile.getOriginalFilename();
				String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
		        String destinationFileName;        
				do { 
		            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;            	
		            	destinationFile = new File(path + folderName1 +destinationFileName);
		            	r.setReciMainPic(destinationFileName);
		            	r.setReciMainPicOriName(sourceFileName);
		            	r.setReciMainPicUrl(path+folderName1);	
		            
		        } while (destinationFile.exists());
		        
		        destinationFile.getParentFile().mkdirs(); 
		        
		        try {
		        	mFile.transferTo(destinationFile);	        		            	           
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}   		
	  if(recipeService.addRecipe(r)){
		  return "redirect:/";
	  } 
	  return "recipe/recipeEnroll"; 
	  }
	    

}
