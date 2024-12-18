package com.infy.service;

import java.util.List;

import com.infy.dto.BookingDTO;
import com.infy.dto.CoachDTO;

public interface CoachServ {
	public String registerCoachServ(CoachDTO coachDTO) throws Exception;
	public Boolean logInCoachServ(Integer coachId,String password) throws Exception;
	public CoachDTO getCoachProfileServ(Integer coachId) throws Exception;
	public List<CoachDTO> getAllCoachsServ() throws Exception;
	public List<BookingDTO> getAllAppointmentsServ(Integer coachId) throws Exception;
	
}
