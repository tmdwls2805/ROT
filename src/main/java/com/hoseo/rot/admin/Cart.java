package com.hoseo.rot.admin;

import lombok.Data;

@Data
public class Cart {
	private int cartNum;
	private int productNum;
	private String productName;
	private int productPrice;
	private String buyer;
	private int buyCount;
	private int buyAmount;
	private String productImg;
}
