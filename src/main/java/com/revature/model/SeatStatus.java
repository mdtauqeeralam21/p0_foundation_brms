package com.revature.model;

public class SeatStatus {
	private String busRegNo;
	private String seatNo;
	private String berthType ;
	private String status;
	public SeatStatus() {
		super();
	}
	public SeatStatus(String busRegNo, String seatNo, String berthType, String status) {
		super();
		this.busRegNo = busRegNo;
		this.seatNo = seatNo;
		this.berthType = berthType;
		this.status = status;
	}
	public String getBusRegNo() {
		return busRegNo;
	}
	public void setBusRegNo(String busRegNo) {
		this.busRegNo = busRegNo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getBerthType() {
		return berthType;
	}
	public void setBerthType(String berthType) {
		this.berthType = berthType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SeatStatus [BusRegNo=" + busRegNo + ", SeatNo=" + seatNo + ", BerthType=" + berthType + ", Status="
				+ status + "]";
	}
	
}
