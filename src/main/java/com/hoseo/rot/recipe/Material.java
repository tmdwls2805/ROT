package com.hoseo.rot.recipe;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Material {
	private int reciInputNum;
	private int matNum;
	private String matName;
	private List<Material2> material2List;
	
}

