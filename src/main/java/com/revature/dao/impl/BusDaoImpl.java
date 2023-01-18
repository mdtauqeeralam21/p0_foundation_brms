package com.revature.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//import com.revature.config.DBConnection;
import com.revature.config.DataBaseConnection;
import com.revature.constants.Message;
import com.revature.dao.BusDao;
import com.revature.exception.BusException;
import com.revature.model.Bus;


public class BusDaoImpl implements BusDao {
	  private static Connection con = DataBaseConnection.getConnection();
	
	
//CASE==1:==================================================================================================================
	@Override
	public List<Bus> showBuses() throws Exception {
        List<Bus> buses = new ArrayList<Bus>();
		
        try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from bus ");
			
			while(rs.next()) {	
				String Bid = rs.getString(1);
				String type = rs.getString(2);
				int totalSeats = rs.getInt(3);
				String berths = rs.getString(4);
				
				
				
				Bus bus = new Bus();
				bus.setBusRegNo(Bid);
				bus.setBusType(type);
				bus.setTotalSeats(totalSeats);
				bus.setTotalBerths(berths);
				
				buses.add(bus);
				
			}
			
			if(rs.next() == true) {
				throw new BusException(Message.BUS_NOT_AVAILABLE);
			}
			
		} catch (Exception e ) {
			System.out.println(e.getMessage());
		}
       
		return buses;
	}
	
//CASE==2:==================================================================================================================

	@Override
	public void addBuses() throws Exception {
		Scanner sc = new Scanner(System.in);
	
		PreparedStatement ps1= con.prepareStatement("insert into bus values (?,?,?,?,?)");
		
		System.out.println("Enter Bus Registration Number: ");
		String busNo = sc.nextLine();
		System.out.println("Enter Bus Type AC/NAC: ");
		String btype = sc.nextLine();
		System.out.println("Enter total no. of Seats: ");
		int tseats = sc.nextInt();
		System.out.println("Enter total no. of Berths(U+L): ");
		String berths = sc.nextLine();
		
		ps1.setString(1,busNo);
		ps1.setString(2, btype);
		ps1.setInt(3, tseats);
		ps1.setString(4, berths);
		
		int k=ps1.executeUpdate();
		if(k>0) {
			System.out.println(Message.VALUES_INSERTED);
		}
		
	}
	
//CASE==3:==================================================================================================================


	@Override
	public void deleteBus() throws Exception {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Bus Registration no to delete: ");
		String regNo =sc.nextLine();

		PreparedStatement ps1= con.prepareStatement("delete from bus where Bus_Reg_No=?");
		ps1.setString(1, regNo);
		int k=ps1.executeUpdate();
		if(k>0) {
			System.out.println(Message.VALUES_DELETED);
		}
			
	}
	
//CASE==4:==================================================================================================================

	@Override
	public void updateBus() throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Bus Registration no : ");
		String regNum=sc.nextLine();
		
		PreparedStatement ps1= con.prepareStatement("select * from bus where Bus_Reg_No=?");
		PreparedStatement ps2= con.prepareStatement("update bus set Bus_Type=?,TotalSeats=?,No_of_Berths=? where Bus_Reg_No=?");
		
		ps1.setString(1,regNum);
		ResultSet rs= ps1.executeQuery();
		if(rs.next()) {
			System.out.println("Previous Bus Type: "+rs.getString(2));
			System.out.println("Enter new Bus Type:");
			String type =sc.nextLine();
			System.out.println("Previous total no. of Seats: "+rs.getInt(3));
			System.out.println("Enter new no. of Seats: ");
			int tseats = sc.nextInt();
			System.out.println("Previous Berths Details: "+rs.getString(4));
			System.out.println("Enter new Berths details: ");
			String berths=sc.nextLine();
			
			
			ps2.setString(1, type);
			ps2.setInt(2, tseats);
			ps2.setString(3, berths);
			ps2.setString(4,regNum);
			
			
			int k=ps2.executeUpdate();
			if(k>0) {
				System.out.println(Message.BUS_UPDATED);
			}
			}else {
				System.err.println(Message.INVALID);
		}	
	}
	
	//case:5===================================================================================================
		@Override
		public void showSeats() throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Bus Registration no : ");
			String regNum=sc.nextLine();
			
			PreparedStatement ps1= con.prepareStatement("select * from seat_status where Bus_Reg_No=?");
			
			ps1.setString(1,regNum);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4));
			}
			
		}

}
