package com.hoseo.rot;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class PureJavaDataAccessTest {
	
	@Before
	public void init() throws Exception {
		final String ddl = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/schema.sql").toURI()))
				.stream()
				.collect(Collectors.joining("\n"));
		
		final String data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/data.sql").toURI()))
				.stream()
				.collect(Collectors.joining());
		
		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
				Statement stmt = con.createStatement();) {			
			stmt.execute(ddl);
			stmt.execute(data);
		}
	}	
	
	//@Test
	public void testCount() throws Exception{
		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "")) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS CNT FROM BOOK");
			rs.next();
			//TODO :: 다음 단위테스트가 통과하도록 코드를 작성하세요.
			//책의 개수
			assertEquals(3, rs.getInt("cnt"));
			//1번 책의 저자의 수
			rs = stmt.executeQuery("SELECT COUNT(*) as cnt FROM AUTHOR where id = 1");
			rs.next();
			assertEquals(2, rs.getInt("cnt"));
		}
		
	}
	
	@Test
	public void testTransaction() throws Exception{
		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "")) {
			//TODO :: 다음 단위테스트가 통과하도록 코드를 작성하세요.
			con.setAutoCommit(false);
			try {
				con.createStatement().executeUpdate("INSERT INTO BOOK VALUES(4,'트랜잭션의 모든것')");
				con.commit();
			}catch(SQLException se) {
				con.rollback();
			}
			//책의 개수
			assertEquals(3, null);
		}		
	}
}
