package com.hoseo.rot.admin;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
	public int addProduct(Product p);
}
