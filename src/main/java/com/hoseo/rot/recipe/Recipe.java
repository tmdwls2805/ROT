package com.hoseo.rot.recipe;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Recipe {
	private String reciId;
	private String reciName;
	private int reciNum;
	private String reciSub;
	private String reciIntro;
	private String reciMainPic;
	private String reciMainPicOriName;
	private String reciMainPicUrl;
	private String reciFind;
	private String reciSit;
	private String reciWay;
	private String reciMat;
	private String reciPer;
	private String reciTim;
	private String reciLev;
	private String reciTip;
	private String reciStatus;
	private int reciLookUp;
	private Timestamp reciregdate;
}
