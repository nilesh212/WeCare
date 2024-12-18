package com.infy.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.BookingDTO;
import com.infy.dto.CoachDTO;
import com.infy.service.CoachServImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coaches")
public class CoachController {
	private static final Logger log=LogManager.getLogger(CoachController.class);
	
	@Autowired
	CoachServImpl coachServ;

	@PostMapping(consumes="application/json")
	public ResponseEntity<String> registerCoach(@Valid @RequestBody CoachDTO coachDTO) throws Exception{
		log.info("Registering Coach....");
		if(!coachDTO.getPassword().equals(coachDTO.getConfirmPassword())) {
			log.error("Password did not match with confirm password.");
			throw new Exception("Password did not match with confirm password.");
		}
		
		if(String.valueOf(coachDTO.getMobileNumber()).length()!=10) {
			log.error("Mobile number should be of 10 digits only.");
			throw new Exception("Mobile Number should be of 10digts only.");
		}
		
		String message=coachServ.registerCoachServ(coachDTO);
		log.info("Registered User.");
		return ResponseEntity.ok(message);
	}
	
	@PostMapping(value="/login",consumes="application/x-www-form-urlencoded")
	public ResponseEntity<Boolean> loginCoach(@RequestParam Integer coachId,@RequestParam String password) throws Exception{
		log.info("Logging User...");
		Boolean isLoggedIn=coachServ.logInCoachServ(coachId,password);
		log.info("Logged In!");
		return ResponseEntity.ok(isLoggedIn);
	}
	
	@PostMapping(value="/{coachId}")
	public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable Integer coachId) throws Exception{
		log.info("Getting coach profile...");
		CoachDTO coachDTO=coachServ.getCoachProfileServ(coachId);
		
		log.info("Fetched coach profile.");
		return ResponseEntity.ok(coachDTO);
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<CoachDTO>> getAllCoachs() throws Exception{
		log.info("Getting all coaches....");
		
		List<CoachDTO> coachs=coachServ.getAllCoachsServ();
		
		return ResponseEntity.ok(coachs);
	}
	
	@PostMapping(value="/booking/{coachId}")
	public ResponseEntity<List<BookingDTO>> getAllAppointments(@PathVariable Integer coachId) throws Exception{
		log.info("Fetching all appointments of coach");
		List<BookingDTO> bookingsDTO=coachServ.getAllAppointmentsServ(coachId);
		log.info("Fetched all appointments of coach");
		return ResponseEntity.ok(bookingsDTO);
		
	}
	
	
}
