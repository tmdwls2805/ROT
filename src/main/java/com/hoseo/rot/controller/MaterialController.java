package com.hoseo.rot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hoseo.rot.admin.AdminService;
import com.hoseo.rot.admin.Cart;
import com.hoseo.rot.member.Member;

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
	
	@PostMapping("/materialListDetails/cart")
	public String addCart(Cart c, ModelMap model, HttpSession session) {
		Member m =  (Member) session.getAttribute("member");
		if(m != null) {
		c.setBuyer(m.getId());
		model.put("cartList", adminService.addCart(c));
		return "redirect:/cart";
		/* return "redirect:/materialListDetails?productNum="+ c.getProductNum(); */
		}else{
			return "redirect:/loginForm";
		}
	}
	
}
