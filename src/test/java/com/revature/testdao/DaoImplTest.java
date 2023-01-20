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
//	@Test
//	public void addBusesTest() throws Exception {
//		BusDaoImpl bd2 = new BusDaoImpl();
//		boolean b1= bd2.addBuses() != null;
//		assert.assertEquals(bd2, bd2);
//	}

}
