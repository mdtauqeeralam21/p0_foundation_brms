package com.revature.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneConversion {
	public static String formatDateToString(Date date,String format,String timeZone) {
		if(date==null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		return sdf.format(date);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println("Default date:"+date.toString());
		System.out.println("System Date: "+formatDateToString(date,"dd mm yyyy hh:mm:ss a",null));
		System.out.println("System Date in IST: "+formatDateToString(date,"dd MMM yyyy hh:mm:ss a","IST"));
		System.out.println("System Date in UTC: "+formatDateToString(date,"dd MMM yyyy hh:mm:ss a","UTC"));
		

	}

}
