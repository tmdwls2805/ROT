package com.hoseo.rot;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.hoseo.rot.mapper.XMLConfigMapper;
import com.hoseo.rot.member.Member;


public class MybatisXMLConfigTest {
//	private SqlSessionFactory sessionFactory;
//	
//	@Before
//	public void init() throws Exception{
//		final String ddl = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/schema.sql").toURI()))
//				.stream()
//				.collect(Collectors.joining("\n"));
//		
//		final String data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/data.sql").toURI()))
//				.stream()
//				.collect(Collectors.joining());
//				
//		try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "");
//				Statement stmt = con.createStatement();) {			
//			stmt.execute(ddl);
//			stmt.execute(data);
//		}
//		
//		sessionFactory =  new SqlSessionFactoryBuilder().build(
//				Resources.getResourceAsStream("mybatis/mybatis-config.xml"));
//		
//	}
//	
//	
//	  @Test public void test() throws Exception { 
//		  try(SqlSession session = sessionFactory.openSession()){ 
//			  XMLConfigMapper Mapper = session.getMapper(XMLConfigMapper.class); 
//			  Member mem = new Member();
//			  mem.setId("admin");
//			  mem.setPassword("admin");
//			  mem.setEmail1("qkrtmdwls280");
//			  mem.setEmail2("gmail.com");
//			  mem.setSent("수신동의");
//			  mem.setPh1("010");
//			  mem.setPh2("4070");
//			  
//	  
//	  // 힌트 : http://www.mybatis.org/mybatis-3/ko/sqlmap-xml.html#Result_Maps
//	  /*assertEquals(2, bookMapper.getBook(1).getAuthors().size()); }*/
//	  
//	  }
//	
//	  }
}
