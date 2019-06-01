package itc.hoseo.cppe.free;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Free {
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private String passwd;
	private Timestamp regDate;
	private int readCount;
	private String ip;
	private int ref;
	private int reStep;
	private int reLevel;
	private String file;

}
