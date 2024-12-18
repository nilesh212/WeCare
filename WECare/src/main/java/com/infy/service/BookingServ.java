package com.infy.service;

import com.infy.dto.BookingDTO;

public interface BookingServ {
	public Boolean rescheduleAppointmentServ(BookingDTO bookingDTO)throws Exception;
	
	public Boolean cancelAppointmentServ(Integer bookingId)throws Exception;
}
