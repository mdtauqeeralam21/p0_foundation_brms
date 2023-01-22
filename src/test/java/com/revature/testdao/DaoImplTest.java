package com.revature.testdao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.impl.BusDaoImpl;

public class DaoImplTest {
	@Test
	public void showBusesTest() throws Exception {
		BusDaoImpl bd = new BusDaoImpl();
		boolean b1= bd.showBuses() != null;
		
		assertEquals(true,b1);
		
	}
}
