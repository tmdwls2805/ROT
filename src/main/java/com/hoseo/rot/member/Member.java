package com.hoseo.rot.member;

import java.sql.Timestamp;
import lombok.Data;


@Data
public class Member {
	// member table
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int zipcode;
	private String addr1;
	private String addr2;
	private String nickname;
	private String profileImg;
	private String profileImgOriName;
	private String profileImgUrl;
	private int point;
	private Timestamp regDate;

}
