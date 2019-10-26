package com.hoseo.rot.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean addProduct(Product p) {
		return adminRepository.addProduct(p)!=0;
	}
	
	public List<Product> getProduct() {
		return adminRepository.getProduct();
	}
	
	public Product getProductDetails(int productNum) {
		return adminRepository.getProductDetails(productNum);
	}
	
	public List<Product> getProductList() {
		return adminRepository.getProductList();
	}

	public boolean addCart(Cart c) {
		return adminRepository.addCart(c)!=0;
	}
	
	public List<Cart> getCart(String buyer) {
		return adminRepository.getCart(buyer);
	}
}
