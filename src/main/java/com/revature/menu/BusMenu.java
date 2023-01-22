package com.revature.menu;

import java.util.List;
import java.util.Scanner;
//import org.apache.log4j.Logger;
import com.revature.constants.Constant;
import com.revature.dao.impl.BusDaoImpl;
import com.revature.model.Bus;

public class BusMenu {
	//private static Logger logger = Logger.getLogger(BusMenu.class);
	public void busMenuDetails() {
		try {
			Scanner sc= new Scanner(System.in);
			while(true) {
				System.out.println(Constant.CHOOSE);
				System.out.println(Constant.OPTIONS);
				System.out.println(Constant.SELECTOPTIONS);
				int choice= Integer.parseInt(sc.next());
				System.out.println(Constant.SEPARATOR);
				
				switch(choice) {
				case 1:
					System.out.println(Constant.LIST_BUSES);
					BusDaoImpl bd = new BusDaoImpl();
					List<Bus> sb= bd.showBuses();
					for(Bus a:sb)
					System.out.println(a);
					System.out.println(Constant.SEPARATOR);
					break;
				case 2:
					System.out.println(Constant.INSERT_BUS);
					BusDaoImpl ab =new BusDaoImpl();
					ab.addBuses();
					System.out.println(Constant.SEPARATOR);
					break;
				case 3:
					System.out.println(Constant.DELETE_BUS);
					BusDaoImpl db =new BusDaoImpl();
					db.deleteBus();
					System.out.println(Constant.SEPARATOR);
					break;
				case 4:
					System.out.println(Constant.UPDATE_BUS);
					BusDaoImpl ub =new BusDaoImpl();
					ub.updateBus();
					System.out.println(Constant.SEPARATOR);
					break;
				case 5:
					System.out.println(Constant.SEAT_STATUS);
					BusDaoImpl seat = new BusDaoImpl();
					seat.showSeats();
					break;
				case 6:
					System.out.println(Constant.EXIT);
					System.exit(0);
				default:
						System.err.println(Constant.INVALIDCHOICE);
						System.out.println(Constant.SEPARATOR);
				}
			
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
