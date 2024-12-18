package com.infy.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{
	public Optional<Booking> findByUserUserIdAndCoachCoachId(Integer userId,Integer coachId);
	@Modifying
	@Query("update Booking b set b.appointmentDate=:appointmentDate,b.slot=:slot where b.bookingId=:bookingId")
	public int updateBooking(@Param("appointmentDate")LocalDate appointmentDate,@Param("slot")String slot,@Param("bookingId")Integer bookingId);
	@Query("select b from Booking b where b.user.userId=:userId")
	public List<Booking> getAllBooking(@Param("userId")Integer userId);
	@Query("select b from Booking b where b.coach.coachId=:coachId")
	public List<Booking> getAllBookingWithCoach(@Param("coachId")Integer coachId);
}
