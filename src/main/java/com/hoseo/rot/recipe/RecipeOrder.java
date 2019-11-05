package com.hoseo.rot.recipe;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class RecipeOrder {
	private int reciInputNum;
	private int orderNum;
	private String orderContent;
}

