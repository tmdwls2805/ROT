package itc.hoseo.cppe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Stopwatch;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ConnectionPoolTest {

	@Test
	public void testInitTime() throws Exception{
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:hsqldb:mem:testdb");
		config.setUsername("SA");
		HikariDataSource ds = new HikariDataSource(config);
		
		
		Stopwatch hikariTimer = Stopwatch.createStarted();
		for(int i = 0 ; i < 10000 ; i++) {
			try(Connection hikariCon = ds.getConnection()){}
		}
		long hikariTime = hikariTimer.stop().elapsed(TimeUnit.MILLISECONDS);
	
		
		Stopwatch driverTimer = Stopwatch.createStarted();
		for(int i = 0 ; i < 10000 ; i++) {
			try(Connection con = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "SA", "")){}
		}
		long driverManagerTime = driverTimer.stop().elapsed(TimeUnit.MILLISECONDS);
		
		log.info("Hikari : {} ms / DriverManager {} ms",hikariTime, driverManagerTime);
		
	}
	
}
