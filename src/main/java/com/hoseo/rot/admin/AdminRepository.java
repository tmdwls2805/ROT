package com.hoseo.rot.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
	public int addProduct(Product p);
	public List<Product> getProduct();
	public Product getProductDetails(int productNum);
	public List<Product> getProductList();
	public int addCart(Cart c);
	public List<Cart> getCart(String buyer);
}
