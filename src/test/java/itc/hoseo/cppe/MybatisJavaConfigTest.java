package itc.hoseo.cppe;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import itc.hoseo.cppe.mapper.JavaConfigMapper;
import itc.hoseo.cppe.member.Member;


public class MybatisJavaConfigTest {
	private SqlSessionFactory sessionFactory;
	
	@Before
	public void init() throws Exception{
		final String ddl = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/schema.sql").toURI()))
				.stream()
				.collect(Collectors.joining("\n"));
		
		final String data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("sql/data.sql").toURI()))
				.stream()
				.collect(Collectors.joining());
				
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl("jdbc:hsqldb:mem:testdb");
		hikariConfig.setUsername("SA");
		DataSource ds = new HikariDataSource(hikariConfig);
		try(Connection con = ds.getConnection()){
			con.createStatement().execute(ddl);
			con.createStatement().execute(data);
		}
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory(); 
		Environment mybatisEnv = new Environment("local", transactionFactory, ds);
		Configuration config = new Configuration(mybatisEnv);
		config.setMapUnderscoreToCamelCase(true);
		config.addMappers("itc.hoseo.cppe.mapper");
		config.getTypeAliasRegistry().registerAlias("Member", Member.class);
		sessionFactory =  new SqlSessionFactoryBuilder().build(config);		
	}
}
