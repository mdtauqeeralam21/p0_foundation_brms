package com.revature.menu;

import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import com.revature.constants.Message;
import com.revature.dao.impl.BusDaoImpl;
import com.revature.model.Bus;

public class BusMenu {
	public void BusMenuDetails() {
		try {
			Scanner sc= new Scanner(System.in);
			while(true) {
				System.out.println("*****************Choice*****************");
				System.out.println("1.List Buses\n2.Add Bus\n3.Delete Bus\n4.Update Bus Details\n5.Display Seat Status\n6.Exit");
				System.out.println("Enter your choice: ");
				int choice= Integer.parseInt(sc.next());
				System.out.println(Message.SEPARATOR);
				
				switch(choice) {
				case 1:
					System.out.println(Message.LIST_BUSES);
					BusDaoImpl bd = new BusDaoImpl();
					List<Bus> sb= bd.showBuses();
					for(Bus a:sb)
					System.out.println(a);
					System.out.println(Message.SEPARATOR);
					break;
				case 2:
					System.out.println(Message.INSERT_BUS);
					BusDaoImpl ab =new BusDaoImpl();
					ab.addBuses();
					System.out.println(Message.SEPARATOR);
					break;
				case 3:
					System.out.println(Message.DELETE_BUS);
					BusDaoImpl db =new BusDaoImpl();
					db.deleteBus();
					System.out.println(Message.SEPARATOR);
					break;
				case 4:
					System.out.println(Message.UPDATE_BUS);
					BusDaoImpl ub =new BusDaoImpl();
					ub.updateBus();
					System.out.println(Message.SEPARATOR);
					break;
				case 5:
					System.out.println(Message.SEAT_STATUS);
					BusDaoImpl seat = new BusDaoImpl();
					seat.showSeats();
					break;
				case 6:
					System.out.println(Message.EXIT);
					System.exit(0);
				default:
						System.err.println(Message.CHOICE);
						System.out.println(Message.SEPARATOR);
				}
			
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
