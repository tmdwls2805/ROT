package com.hoseo.rot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.hoseo.rot.admin.AdminService;

@Controller
public class MaterialController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/materialList")
	public String materialList(ModelMap m) {
		m.put("productList", adminService.getProduct());
		return "material/materialList";
	}
	
	@GetMapping("/materialListDetails")
	public String materialListDetails(ModelMap m, int productNum) {
		m.put("product" , adminService.getProductDetails(productNum));
		m.put("productList",  adminService.getProductList());
		return "material/materialListDetails";
	}
	
}
