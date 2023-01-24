package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;
import com.revature.constants.Constant;
import com.revature.dao.impl.BusDaoImpl;
import com.revature.model.Bus;

public class BusMenu {
	private static Logger logger = Logger.getLogger(BusMenu.class);
	public void busMenuDetails() {
		try {
			Scanner sc= new Scanner(System.in);
			while(true) {
				logger.info(Constant.CHOOSE);
				logger.info(Constant.OPTIONS);
				logger.info(Constant.SELECTOPTIONS);
				int choice= Integer.parseInt(sc.next());
				logger.info(Constant.SEPARATOR);
				
				switch(choice) {
				case 1:
					logger.info(Constant.LIST_BUSES);
					BusDaoImpl bd = new BusDaoImpl();
					List<Bus> sb= bd.showBuses();
					for(Bus a:sb)
					logger.info(a);
					logger.info(Constant.SEPARATOR);
					break;
				case 2:
					logger.info(Constant.INSERT_BUS);
					BusDaoImpl ab =new BusDaoImpl();
					ab.addBuses();
					logger.info(Constant.SEPARATOR);
					break;
				case 3:
					logger.info(Constant.DELETE_BUS);
					BusDaoImpl db =new BusDaoImpl();
					db.deleteBus();
					logger.info(Constant.SEPARATOR);
					break;
				case 4:
					logger.info(Constant.SEAT_STATUS);
					BusDaoImpl seat = new BusDaoImpl();
					seat.showSeats();
					break;
				case 5:
					logger.info(Constant.EXIT);
					System.exit(0);
				default:
						System.err.println(Constant.INVALIDCHOICE);
						logger.info(Constant.SEPARATOR);
				}
			
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
