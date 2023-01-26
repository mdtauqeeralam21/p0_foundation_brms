package com.revature.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import com.revature.config.DataBaseConnection;
import com.revature.constants.Constant;
import com.revature.dao.BusDao;
import com.revature.exception.BusException;
import com.revature.menu.BusMenu;
import com.revature.model.Bus;
import com.revature.model.SeatStatus;


public class BusDaoImpl implements BusDao {
	  private static Connection con = DataBaseConnection.getConnection(); 
	  
	
//CASE==1:==================================================================================================================
	@Override
	public List<Bus> showBuses() {
        List<Bus> buses = new ArrayList<>();
        try {
			String selectQuery= Constant.SELECTQUERY;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()) {	
				
				Bus bus = new Bus();
				bus.setBusRegNo(rs.getString(1));
				bus.setBusType(rs.getString(2));
				bus.setTotalSeats(rs.getInt(3));
				bus.setTotalBerths(rs.getString(4));
				
				buses.add(bus);
				
			}
			
			if(rs.next() == true) {
				throw new BusException(Constant.BUS_NOT_AVAILABLE);
			}
			
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
       
		return buses;
	}
	
//CASE==2:==================================================================================================================

	@Override
	public void addBuses() throws Exception {
		Scanner sc = new Scanner(System.in);
		String insertQuery = Constant.INSERTBUSQUERY;
		PreparedStatement ps1= con.prepareStatement(insertQuery);
		PreparedStatement ps2= con.prepareStatement(Constant.SEAT_INSERTION);
		
		System.out.println("Enter Bus Registration Number: ");
		String busNo = sc.nextLine();
		System.out.println("Enter Bus Type AC/NAC: ");
		String btype = sc.nextLine();
		System.out.println("Enter total no. of Berths(U+L): ");
		String berths = sc.nextLine();
		System.out.println("Enter total no. of Seats: ");
		int tseats = sc.nextInt();
		
		ps1.setString(1,busNo);
		ps1.setString(2, btype);
		ps1.setInt(3, tseats);
		ps1.setString(4, berths);
		
		int k=ps1.executeUpdate();
		if(k>0) {
			System.out.println(Constant.VALUES_INSERTED);
			System.out.println("Please insert seat details for bus "+busNo+" with berths "+berths);
			
			for(int i=1;i<=tseats;i++) {
				
			System.out.println("Enter seat no: "+i);
			String seatno= sc.next();
			System.out.println("Enter berth type (U/L): ");
			String berthType = sc.next();
			System.out.println("Enter seat availabilty(Available/Booked): ");
			String avail = sc.next();
			System.out.println("Enter PNR No (NULL if not assigned) ");
			String pnrNo =sc.next();
			
			ps2.setString(1, busNo);
			ps2.setString(2, seatno);
			ps2.setString(3,berthType);
			ps2.setString(4, avail);
			ps2.setString(5, pnrNo);
			
			int j=ps2.executeUpdate();
			if(j>0) {
				System.out.println(i+" Seat details added: ");
			}else {
				System.err.println("Invalid Bus ID");
			}
			}
		}
		
	}
	
//CASE==3:==================================================================================================================


	@Override
	public void deleteBus() throws Exception {

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Bus Registration no to delete: ");
		String regNo =sc.nextLine();
		String seatDelete=Constant.SEAT_DELETION;
		String deleteQuery = Constant.DELETEBUSQUERY;
		
		PreparedStatement ps1= con.prepareStatement(seatDelete);
		PreparedStatement ps2= con.prepareStatement(deleteQuery);
		
		ps1.setString(1, regNo);
		ps1.executeUpdate();
		
		ps2.setString(1, regNo);
		int k=ps2.executeUpdate();
		if(k>0) {
			System.out.println(Constant.VALUES_DELETED);
		}else {
			System.err.println(Constant.INVALID);
	}	
			
	}
	
//CASE==4:==================================================================================================================

//	@Override
//	public void updateBus() throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Bus Registration no : ");
//		String regNum=sc.nextLine();
//		String selectAbus=Constant.SELECTABUS;
//		String updateBus = Constant.UPDATEBUSVALUES;
//		PreparedStatement ps1= con.prepareStatement(selectAbus);
//		PreparedStatement ps2= con.prepareStatement(updateBus);
//		
//		ps1.setString(1,regNum);
//		ResultSet rs= ps1.executeQuery();
//		if(rs.next()) {
//			System.out.println("Previous Bus Type: "+rs.getString(2));
//			System.out.println("Enter new Bus Type:");
//			String type =sc.nextLine();
//		
//			System.out.println("Previous Berths Details: "+rs.getString(4));
//			System.out.println("Enter new Berths details: ");
//			String berths=sc.nextLine();
//			
//			System.out.println("Previous total no. of Seats: "+rs.getInt(3));
//			System.out.println("Enter new no. of Seats: ");
//			int tseats = sc.nextInt();
//			
//			ps2.setString(1, type);
//			ps2.setInt(2, tseats);
//			ps2.setString(3, berths);
//			ps2.setString(4,regNum);
//			
//			
//			int k=ps2.executeUpdate();
//			if(k>0) {
//				System.out.println(Constant.BUS_UPDATED);
//			}
//			}else {
//				System.err.println(Constant.INVALID);
//		}	
//	}
//	
//case:5===================================================================================================
		@Override
		public void showSeats() throws Exception {
			Scanner sc = new Scanner(System.in);
			try {
			String selectQuery = Constant.SELECTSEATSTATUS;
			System.out.println("Enter Bus Registration no : ");
			String regNum=sc.nextLine();
			
			PreparedStatement ps1= con.prepareStatement(selectQuery);
			
			ps1.setString(1,regNum);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5));
			
		}
			}catch (SQLException e ) {
				System.err.println(e.getMessage());
			}
			System.out.println("Select 'y' to book seat.");
			String c = sc.next();
			if(c.equalsIgnoreCase("y")) {
			
			System.out.println("Select seat to book: ");
			System.out.println("Enter Seat No: ");
			String stno = sc.next();
			String seatQuery= "update seat_status set status='Booked' where Seat_No=?";
			PreparedStatement ps2= con.prepareStatement(seatQuery);
			ps2.setString(1, stno);
			int k = ps2.executeUpdate();
			if(k>0) {
				System.out.println("Seat Booked Successfully.");
			}else {
				System.err.println("Wrong seat number.");
			}
			}else {
				return;
			}
			
}
		
		
//=====CASE:6==================================================================================================

		@Override
		public void admin() {
			String userid=null;
			String password= null;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter userid: ");
			userid = sc.next();
			System.out.println("Enter password: ");
			password= sc.next();
			try {
				PreparedStatement ps= con.prepareStatement("select * from admin");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(userid.equals(rs.getString(1)) &&password.equals(rs.getString(2))) {
						System.out.println(Constant.WELCOME_MESSAGE);
						BusMenu obj= new BusMenu();
						obj.busMenuDetails();
					}else {
						System.out.println("Invalid userid or password");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
			
