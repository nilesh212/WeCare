package com.infy.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.BookingDTO;
import com.infy.service.BookingServImpl;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
	private static final Logger log=LogManager.getLogger(BookingController.class);
	
	@Autowired
	BookingServImpl bookingServ;

	@PutMapping(value="/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId,@RequestBody BookingDTO bookingDTO)throws Exception{
		log.info("Rescheduling Appointemnt...");
		bookingDTO.setBookingId(bookingId);
		Boolean isReschedule=bookingServ.rescheduleAppointmentServ(bookingDTO);
		log.info("Rescheduled Appointment!");
		return ResponseEntity.ok(isReschedule);
	}
	
	
	@DeleteMapping(value="/cancel/{bookingId}")
	public ResponseEntity<Boolean> cancelAppointment(@PathVariable Integer bookingId)throws Exception{
		log.info("Cancelling Appointemnt...");
		Boolean isCancel=bookingServ.cancelAppointmentServ(bookingId);
		log.info("Canceled Appointment!");
		return ResponseEntity.ok(isCancel);
	}
		
	
}
