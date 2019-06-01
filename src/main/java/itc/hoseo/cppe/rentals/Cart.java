package itc.hoseo.cppe.rentals;

import lombok.Data;

@Data
public class Cart {
	private int cartId;
	private String buyer;
	private int carId;
	private String carTitle;
	private int buyPrice;
	private byte buyCount;
	private String carImage;
}
