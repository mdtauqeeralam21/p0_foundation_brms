package com.revature.constants;

public class Constant {
	public static final String INVALID ="Invalid Bus Number";
	public static final String CHOICE ="Invalid Choice";
	public static final String TYPE ="Invalid Bus Type";
	public static final String BUS_UPDATED ="Bus Details Updated";
	public static final String VALUES_INSERTED ="Bus Details Added Successfully";
	public static final String VALUES_NOT_INSERTED ="Values Not Inserted";
	public static final String VALUES_DELETED ="Bus Values Deleted Successfully";
	public static final String BUS_NOT_AVAILABLE ="Buses Not Available";
	public static final String DELETE_BUS ="**********Deleting Bus**********";
	public static final String UPDATE_BUS ="**********Updating Bus Details**********";
	public static final String INSERT_BUS= "**********Inserting Bus Details**********";
	public static final String LIST_BUSES ="**********Listing All The Buses**********";
	public static final String SEPARATOR= "*****************************************";
	public static final String EXIT= "*****THANK YOU*****";
	public static final String SEAT_STATUS = "Displaying Seat Status of Bus";
	public static final String SELECTQUERY = "select * from bus ";
	public static final String SELECTABUS = "select * from bus where Bus_Reg_No=?";
	public static final String UPDATEBUSVALUES = "update bus set Bus_Type=?,TotalSeats=?,No_of_Berths=? where Bus_Reg_No=?";
	public static final String SELECTSEATSTATUS = "select * from seat_status where Bus_Reg_No=?";
	public static final String INSERTBUSQUERY = "insert into bus values (?,?,?,?,?)";
	public static final String DELETEBUSQUERY = "delete from bus where Bus_Reg_No=?";
	
	
}
