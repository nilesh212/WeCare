package com.infy.service;

import java.util.List;

import com.infy.dto.BookingDTO;
import com.infy.dto.UserDTO;

public interface UserServ {
	public String registerUserServ(UserDTO userDTO) throws Exception;
	public Boolean loginUserServ(String email,String password) throws Exception;
	public UserDTO getUserServ(Integer userId) throws Exception;
	public Boolean bookAppointmentServ(BookingDTO bookingDTO) throws Exception;
	public List<BookingDTO> getAllAppointmentServ(Integer userId) throws Exception;
	
}
