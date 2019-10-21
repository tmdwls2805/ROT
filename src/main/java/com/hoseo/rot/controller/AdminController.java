package com.hoseo.rot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hoseo.rot.admin.AdminService;
import com.hoseo.rot.admin.Product;
import com.hoseo.rot.member.Member;
import com.hoseo.rot.member.MemberService;



@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/productEnroll")
	public String productEnroll() {
		return "admin/productEnroll";
	}
	
	@Autowired
	private Environment env;
	
	@PostMapping("/addProduct")
	public String addProduct(Product p, HttpServletRequest request, MultipartHttpServletRequest multi) {
		Iterator<String> imgs = multi.getFileNames();
		String path = env.getProperty("upload-product-path");
		String folderName1 = "product/"; 
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
	            	p.setProductImg(destinationFileName);
	            	p.setProductImgOriName(sourceFileName);
	            	p.setProductImgUrl(path+folderName1);	
	            
	        } while (destinationFile.exists()); 
	        
	        destinationFile.getParentFile().mkdirs(); 
	        
	        try {
	        	mFile.transferTo(destinationFile);	        		            	           
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}        
		if(adminService.addProduct(p)) {			
			return "redirect:/productEnroll";
		}
		return "admin/productEnroll"; 
	}

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/blank")
	public String getMemberTest(ModelMap m) {
		m.put("memberList", memberService.getMemberTest());
		return "admin/blank";
	}

	
	
	
	@GetMapping("/management")
	public String management() {
		return "admin/management";
	}
	
	@GetMapping("/charts")
	public String charts() {
		return "admin/charts";
	}
	
	@GetMapping("/tables")
	public String tables() {
		return "admin/tables";
	}

}
