package com.hoseo.rot.recipe;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class RecipeOrder {
	private int reciNum;
	private int orderNum;
	private String orderContent;
	private String orderPic;

}

