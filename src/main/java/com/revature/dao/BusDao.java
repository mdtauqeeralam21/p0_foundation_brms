package com.revature.dao;

import java.util.List;
import com.revature.model.Bus;

public interface BusDao {
		
		public List<Bus> showBuses();
		public void addBuses() throws  Exception;
		public void deleteBus() throws Exception;
		public void updateBus() throws Exception;
		public void showSeats() throws Exception;
		public void admin();

}
