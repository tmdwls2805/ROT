package com.hoseo.rot.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public boolean addProduct(Product p) {
		return adminRepository.addProduct(p)==1;
	}

}
