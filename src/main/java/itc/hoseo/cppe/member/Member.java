package itc.hoseo.cppe.member;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Member {
	private String id;
	private String password;
	private String name;
	private String email1;
	private String email2;
	private String sent;
	private int ph1;
	private int ph2;
	private int ph3;
	private String gender;
	private String smoking;
	private String vehicle;
	private int birth1;
	private int birth2;
	private int birth3;
	private int zipcode;
	private String addr1;
	private String addr2;
	private Timestamp regDate;
	private int point;
	private int accumPoint;
	private String pointGrade;
}
