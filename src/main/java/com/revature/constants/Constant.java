package com.revature.constants;

public class Constant {
	private Constant() {}
	public static final String INVALID ="Invalid Bus Number";
	public static final String INVALIDCHOICE ="Invalid Choice";
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
	public static final String INSERTBUSQUERY = "insert into bus values (?,?,?,?)";
	public static final String DELETEBUSQUERY = "delete from bus where Bus_Reg_No=?";
	public static final Object CHOOSE = "*****************𝑪𝒉𝒐𝒐𝒔𝒆 𝑶𝒑𝒕𝒊𝒐𝒏*****************";
	public static final Object OPTIONS = "𝟏.𝑳𝒊𝒔𝒕 𝑩𝒖𝒔𝒆𝒔\n𝟐.𝑨𝒅𝒅 𝑩𝒖𝒔\n𝟑.𝑫𝒆𝒍𝒆𝒕𝒆 𝑩𝒖𝒔\n𝟒.𝑼𝒑𝒅𝒂𝒕𝒆 𝑩𝒖𝒔 𝑫𝒆𝒕𝒂𝒊𝒍𝒔\n𝟓.𝑫𝒊𝒔𝒑𝒍𝒂𝒚 𝑺𝒆𝒂𝒕 𝑺𝒕𝒂𝒕𝒖𝒔\n𝟔.𝑬𝒙𝒊𝒕";
	public static final Object SELECTOPTIONS = "𝑬𝒏𝒕𝒆𝒓 𝒚𝒐𝒖𝒓 𝒄𝒉𝒐𝒊𝒄𝒆:  ";
	
}
