package itc.hoseo.cppe.reboard;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReBoard {
	private int reNum;
	private String reName;
	private String reContent;
	private Timestamp reDate;
	private String reIpAddr;
	private int boardNum;
}
