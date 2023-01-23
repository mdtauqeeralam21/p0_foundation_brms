package com.revature.app;
import com.revature.dao.impl.BusDaoImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		BusDaoImpl bdi = new BusDaoImpl();
		bdi.admin();
	}
}
