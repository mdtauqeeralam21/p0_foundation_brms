package com.revature.testdao;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.revature.config.DataBaseConnection;

public class DBConnectionTest {
	
	@Test 
	public void getConnectionTest() {
		new DataBaseConnection();
		assertNotNull(DataBaseConnection.getConnection());
	}

}