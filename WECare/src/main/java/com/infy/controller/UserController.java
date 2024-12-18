package com.infy.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.BookingDTO;
import com.infy.dto.UserDTO;
import com.infy.service.UserServImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/users")
public class UserController {
	private static final Logger log=LogManager.getLogger(UserController.class);
	
	@Autowired
	UserServImpl userServ;

	@PostMapping(consumes="application/json")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO) throws Exception{
		log.info("Registering User....");
//		List<Exception> exceptions=new ArrayList<Exception>();
		if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
			log.error("Password did not match with confrim Password.");
//			exceptions.add(new Exception("Password did not match with confrim Password."));
			throw new Exception("Password did not match with confrim Password.");
		}
		if(String.valueOf(userDTO.getMobileNumber()).length()!=10) {
			log.error("Mobile number should be of 10 digits only.");
//			exceptions.add(new Exception("Mobile number should be of 10 digits only."));
			throw new Exception("Mobile number should be of 10 digits only.");
		}
		if(String.valueOf(userDTO.getPincode()).length()!=6) {
			log.error("Pincode should be of 6 digits only.");
//			exceptions.add(new Exception("Pincode should be of 6 digits only."));
			throw new Exception("Pincode should be of 6 digits only.");
		}
//		if(!exceptions.isEmpty()) {
//			throw exceptions;
//		}
		String message=userServ.registerUserServ(userDTO);
		log.info("Registered user.");
		return ResponseEntity.ok(message);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Boolean> loginUser(@RequestParam String email,@RequestParam String password)throws Exception{
		log.info("Logging In user....");
		Boolean isLoggedIn=userServ.loginUserServ(email,password);
		log.info("Received  user.");
		return ResponseEntity.ok(isLoggedIn);
	}
	
	@PostMapping(value="/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId) throws Exception{
		log.info("Fetching user Data...");
		UserDTO userDTO=userServ.getUserServ(userId);
		log.info("Fetched User Data");
		return ResponseEntity.ok(userDTO);
	}
	
	@PostMapping(value="/{userId}/booking/{coachId}")
	public ResponseEntity<Boolean> bookAppointment(@PathVariable Integer userId,@PathVariable Integer coachId,@Valid @RequestBody BookingDTO bookingDTO)throws Exception{
		log.info("Booking An Appointment...");
		bookingDTO.setUserId(userId);
		bookingDTO.setCoachId(coachId);
		Boolean isBooked=userServ.bookAppointmentServ(bookingDTO);
		log.info("Appointment Booked.");
		return ResponseEntity.ok(isBooked);
	}
	
	@PostMapping(value="/booking/{userId}")
	public ResponseEntity<List<BookingDTO>> getAllAppointment(@PathVariable Integer userId) throws Exception{
		log.info("Getting All Appointment of the user....");
		List<BookingDTO> bookingDTOs=userServ.getAllAppointmentServ(userId);
		log.info("Fetched All Appointment of ther user.");
		return ResponseEntity.ok(bookingDTOs);
	}
	
}
