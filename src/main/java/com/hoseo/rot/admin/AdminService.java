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
	
	public List<Cart> getCart(String buyer) {
		return adminRepository.getCart(buyer);
	}
	
	public int cartCount(Cart c) {              // 아이디와 상품번호로 count select
		return adminRepository.cartCount(c); 
	}
	
	public boolean alterCountCart(Cart c) {      // 장바구니 update
		return adminRepository.addCountCart(c)!=0;
	}
	
	public boolean addCart(Cart c) {             // 장바구니 insert
		return adminRepository.addCart(c)!=0;
	}
	
	public int userCartCount(String buyer) {
		return adminRepository.userCartCount(buyer);
	}
}
