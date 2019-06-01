package itc.hoseo.cppe.rentals;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Buy {
	private Long buyId;
	private String buyer;
	private int carId;
	private String carTitle;
	private int buyPrice;
	private byte buyCount;
	private String carImage;
	private Timestamp buyDate;
	private String deliveryName;
	private String deliveryTel;
	private int deliveryZipcode;
	private String deliveryAddr2;
	private String deliveryAddr1;
	private String sanction;
	private String hour;
	private String minute;
	private String amPm;
	private String date;
	private String payment;
}
