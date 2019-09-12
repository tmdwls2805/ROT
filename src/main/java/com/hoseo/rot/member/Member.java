package com.hoseo.rot.member;

import java.sql.Timestamp;
import lombok.Data;


@Data
public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private int zipcode;
	private String addr1;
	private String addr2;
	private int point;
	private Timestamp regDate;

}
