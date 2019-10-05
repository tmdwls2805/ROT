package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hoseo.rot.admin.AdminService;
import com.hoseo.rot.admin.Product;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/productEnroll")
	public String productEnroll() {
		return "admin/productEnroll";
	}
	
	@PostMapping("/productEnroll")
	public String enroll(Product p) {
		if(adminService.addProduct(p)) {
			return "redirect:/";
		}
		return "admin/productEnroll";
	}
	
	@GetMapping("/blank")
	public String blank() {
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
