package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BookingDTO;
import com.infy.dto.CoachDTO;
import com.infy.entity.Booking;
import com.infy.entity.Coach;
import com.infy.repository.BookingRepository;
import com.infy.repository.CoachRepository;

@Service
public class CoachServImpl implements CoachServ{
	private static final Logger log=LogManager.getLogger(CoachServImpl.class);

	@Autowired
	CoachRepository coachRepo;
	@Autowired
	BookingRepository bookRepo;
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public String registerCoachServ(CoachDTO coachDTO) throws Exception {
		// TODO Auto-generated method 
		Optional<Coach> optionalCoach=coachRepo.findByName(coachDTO.getName());
		if(optionalCoach.isPresent()) {
			log.error("Coach Already Exists.");
			throw new Exception("Coach Already Exists.");
		}
		coachRepo.saveAndFlush(modelMapper.map(coachDTO, Coach.class));
		return "Successfully created Coach Profile.";
	}

	@Override
	public Boolean logInCoachServ(Integer coachId, String password) throws Exception {
		// TODO Auto-generated method stub
		Optional<Coach> optionalCoach=coachRepo.findByCoachIdAndPassword(coachId,password);
		if(optionalCoach.isEmpty()) {
			log.error("Credentials are wrong!");
			throw new Exception("Credentials are wrong!");
		}
		
		return true;
	}

	@Override
	public CoachDTO getCoachProfileServ(Integer coachId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Coach> optionalCoach=coachRepo.findById(coachId);
		if(optionalCoach.isEmpty()) {
			log.error("Ooops!  Coach Does not exists.");
			throw new Exception("Ooops!  Coach Does not exists.");
		}
		
		return modelMapper.map(optionalCoach.get(), CoachDTO.class);
	}

	@Override
	public List<CoachDTO> getAllCoachsServ() throws Exception {
		// TODO Auto-generated method stub
		List<Coach> coaches=coachRepo.findAll();
		List<CoachDTO> coachesDTO=new ArrayList<CoachDTO>();
		for(Coach coach:coaches) {
			coachesDTO.add(modelMapper.map(coach, CoachDTO.class));
		}
		return coachesDTO;
	}

	@Override
	public List<BookingDTO> getAllAppointmentsServ(Integer coachId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Coach> optCoach=coachRepo.findById(coachId);
		if(optCoach.isEmpty()) {
			log.error("Coach with given id does not exists!");
			throw new Exception("Coach with given id does not exists!");
		}
		
		List<Booking> bookings=bookRepo.getAllBookingWithCoach(coachId);
		
		List<BookingDTO> bookingsDTO=new ArrayList<BookingDTO>();
		
		for(Booking booking:bookings) {
			bookingsDTO.add(modelMapper.map(booking, BookingDTO.class));
		}
		
		return bookingsDTO;
	}

}
