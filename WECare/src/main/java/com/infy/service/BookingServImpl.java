package com.infy.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BookingDTO;
import com.infy.entity.Booking;
import com.infy.repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServImpl implements BookingServ{
	private static final Logger log=LogManager.getLogger(BookingServImpl.class);
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Transactional
	@Override
	public Boolean rescheduleAppointmentServ(BookingDTO bookingDTO) throws Exception{
		// TODO Auto-generated method stub
		Optional<Booking> optBooking=bookingRepo.findById(bookingDTO.getBookingId());
		if(optBooking.isEmpty()) {
			log.error("Booking with given bookingId does not exists!");
			throw new Exception("Booking with given bookingId does not exists!");
		}
//		Booking booking=optBooking.get();
//		booking.setAppointmentDate(bookingDTO.getAppointmentDate());
//		booking.setSlot(bookingDTO.getSlot());
		bookingRepo.updateBooking(bookingDTO.getAppointmentDate(),bookingDTO.getSlot(),bookingDTO.getBookingId());
		return true;
	}

	@Override
	public Boolean cancelAppointmentServ(Integer bookingId) throws Exception {
		// TODO Auto-generated method stub
		Optional<Booking> optBooking=bookingRepo.findById(bookingId);
		if(optBooking.isEmpty()) {
			log.error("Booking with given bookingId does not exists!");
			throw new Exception("Booking with given bookingId does not exists!");
		}
		bookingRepo.deleteById(bookingId);
		return true;
	}

}
