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
import com.infy.dto.UserDTO;
import com.infy.entity.Booking;
import com.infy.entity.Coach;
import com.infy.entity.User;
import com.infy.repository.BookingRepository;
import com.infy.repository.CoachRepository;
import com.infy.repository.UserRepository;

@Service
public class UserServImpl implements UserServ{
	private static final Logger log=LogManager.getLogger(UserServImpl.class);
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	CoachRepository coachRepo;
	@Autowired
	BookingRepository bookRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public String registerUserServ(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> optUser=userRepo.findByName(userDTO.getName());
		
		if(optUser.isPresent()) {
			log.error("User already Exists!");
			throw new Exception("User already Exists!");
		}
		
		userRepo.saveAndFlush(modelMapper.map(userDTO, User.class));
		
		
		return "Successfully registered user!";
	}

	@Override
	public Boolean loginUserServ(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<User> optUser=userRepo.findByEmailAndPassword(email, password);
		if(optUser.isEmpty()) {
			log.error("Credentials are wrong!");
			throw new Exception("Credentials are wrong!");
		}
		
		return true;
	}

	@Override
	public UserDTO getUserServ(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> optUser=userRepo.findById(userId);
		if(optUser.isEmpty()) {
			log.error("User with given Id does not exists!");
			throw new Exception("User with given Id does not exists!");
		}
		return modelMapper.map(optUser, UserDTO.class);
	}

	@Override
	public Boolean bookAppointmentServ(BookingDTO bookingDTO) throws Exception {
		// TODO Auto-generated method stub
		Optional<Coach> optCoach=coachRepo.findById(bookingDTO.getCoachId());
		if(optCoach.isEmpty()) {
			log.error("Coach with given Id does not exists!");
			throw new Exception("Coach with given Id does not exists!");
		}
		
		Optional<User> optUser=userRepo.findById(bookingDTO.getUserId());
		if(optUser.isEmpty()) {
			log.error("User with given Id does not exists!");
			throw new Exception("User with given Id does not exists!");
		}
		
		Optional<Booking> optBooking=bookRepo.findByUserUserIdAndCoachCoachId(bookingDTO.getUserId(),bookingDTO.getCoachId());
		if(optBooking.isPresent()) {
			log.error("Booking Already Exists!");
			throw new Exception("Booking Already Exists!");
		}
		Booking booking=modelMapper.map(bookingDTO, Booking.class);
		booking.setCoach(optCoach.get());
		booking.setUser(optUser.get());
		
		bookRepo.saveAndFlush(booking);
		return true;
	}

	@Override
	public List<BookingDTO> getAllAppointmentServ(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> optUser=userRepo.findById(userId);
		if(optUser.isEmpty()) {
			log.error("User with given id does not exists.");
			throw new Exception("User with given id does not exists.");
		}
		
		List<Booking> bookings=bookRepo.getAllBooking(userId);
		System.out.println(bookings);
		List<BookingDTO> bookingsDTO=new ArrayList<BookingDTO>();
		
		for(Booking booking:bookings) {
			bookingsDTO.add(modelMapper.map(booking, BookingDTO.class));
		}
		System.out.println(bookingsDTO);
		
		return bookingsDTO;
	}

}
