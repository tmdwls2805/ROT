package itc.hoseo.cppe.carpool;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Carpool {

	private int carpoolId;
	private String userId;
	private String choice;
	private String purpose;
	private String sPoint;
	private String dPoint;
	private String wPoint;
	private String date;
	private String amPm;
	private int hour;
	private int minute;
	private int personNum;
	private int price;
	private String insurance;
	private String smoking;
	private String content;
	private Timestamp regdate;
	private String userName;
}
