package com.revature.model;

public class Bus {
		
		private String busRegNo;
		private String busType;
		private int totalSeats;
		private String totalBerths;
		
		
		public Bus() {
			super();
		}

		public Bus(String busRegNo, String busType, int totalSeats, String totalBerths) {
			super();
			this.busRegNo = busRegNo;
			this.busType = busType;
			this.totalSeats = totalSeats;
			this.totalBerths = totalBerths;
		}

		public String getBusRegNo() {
			return busRegNo;
		}

		public void setBusRegNo(String busRegNo) {
			this.busRegNo = busRegNo;
		}

		public String getBusType() {
			return busType;
		}

		public void setBusType(String busType) {
			this.busType = busType;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public String getTotalBerths() {
			return totalBerths;
		}

		public void setTotalBerths(String totalBerths) {
			this.totalBerths = totalBerths;
		}

		@Override
		public String toString() {
			return "Bus [BusRegNo=" + busRegNo + ", BusType=" + busType + ", TotalSeats=" + totalSeats + ", TotalBerths="
					+ totalBerths + "]";
		}
		
		
		
}
