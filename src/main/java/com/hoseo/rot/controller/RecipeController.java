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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hoseo.rot.admin.AdminService;
import com.hoseo.rot.member.Member;
import com.hoseo.rot.recipe.Material;
import com.hoseo.rot.recipe.Material2;
import com.hoseo.rot.recipe.Recipe;
import com.hoseo.rot.recipe.RecipeOrder;
import com.hoseo.rot.recipe.RecipeService;


@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	@Autowired
	private AdminService adminService;

	 @GetMapping("/recipeList")
	 public String recipeList(ModelMap m) {
		 m.put("recipeList", recipeService.getRecipeList());
		 m.put("recipeCount", recipeService.getRecipeCount());
		 return "recipe/recipeList";
	 }
	 
	 @GetMapping("/recipeListDetails")
	 public String recipeListDetails() {
		 
		 return "recipe/recipeListDetails";
	 }
	
	  @GetMapping("/recipeEnroll") 
	  public String recipeEnroll() { 
		  return "recipe/recipeEnroll"; 
		  }
	  
	  @Autowired
	  private Environment env;
	  
	  @PostMapping("/recipeEnroll") 
	  public String enroll(Recipe r, RecipeOrder ro, Material m, Material2 m2, HttpServletRequest h, MultipartHttpServletRequest multi) {
			Iterator<String> imgs = multi.getFileNames();
			String path = env.getProperty("upload-img-path");
			String folderName1 = "recipe/"; 
			String folderName2 = "recipe/";
			String thumb = "yes"; 
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
			            if(thumb.equals("yes")) {	            	
				            destinationFile = new File(path + folderName1 +destinationFileName);
			            	r.setReciMainPic(destinationFileName);
			            	r.setReciMainPicOriName(sourceFileName);
			            	r.setReciMainPicUrl(path+folderName1);
			            	thumb = "no";
			            } else {
			            	destinationFile = new File(path + folderName2 +destinationFileName);
			            	ro.setOrderPic(destinationFileName);
			            	ro.setOrderPicOriName(sourceFileName);
			            	ro.setOrderPicUrl(path+folderName2);
			            }
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
		  
		  String [] matName = h.getParameterValues("matName");
		  String [] mat2Find = h.getParameterValues("mat2Find");
		  String [] mat2Vol = h.getParameterValues("mat2Vol");
		  String [] orderContent = h.getParameterValues("orderContent");
		  String [] orderPic = h.getParameterValues("orderPic");
		  String [] orderPicOriName = h.getParameterValues("orderPicOriName");
		  String [] orderPicUrl = h.getParameterValues("orderPicUrl");
		  
		  m.setReciInputNum(r.getReciNum());
		  for(int i = 0; i<matName.length; i++) {
			  m.setMatName(matName[i]);
			  recipeService.addMaterial(m);
			  m2.setReciInputNum(r.getReciNum());
			  m2.setMatInputNum(m.getMatNum());
			  for(int j=0; j<mat2Find.length; j++) {
				  m2.setMat2Find(mat2Find[j]);
				  m2.setMat2Vol(mat2Vol[j]);
				  recipeService.addMaterial2(m2);
			  }
		  }
		  
		  ro.setReciInputNum(r.getReciNum());
		  for(int i = 0; i<orderContent.length; i++) {
			  ro.setOrderContent(orderContent[i]);
//			  ro.setOrderPic(orderPic[i]);
// 			  ro.setOrderPicOriName(orderPicOriName[i]);
//			  ro.setOrderPicUrl(orderPicUrl[i]);
			  recipeService.addRecipeOrder(ro);
		  }
		  
		  
		  
		  
		  return "redirect:/";
	  } 
	  return "recipe/recipeEnroll"; 
	  }
	    

}
