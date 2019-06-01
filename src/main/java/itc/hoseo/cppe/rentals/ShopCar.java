package itc.hoseo.cppe.rentals;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class ShopCar {
	private int carId;
	private String carKind;
	private String carTitle;
	private String carOil;
	private int carPrice;
	private short carCount;
	private String carImage;
	private String carContent;
	private byte discountRate1;
	private byte discountRate2;
	private Timestamp regDate;

}
