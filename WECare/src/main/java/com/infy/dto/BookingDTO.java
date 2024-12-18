package com.infy.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;


public class BookingDTO {
	private Integer bookingId;
	
	private Integer coachId;
	
	private Integer userId;
	@NotNull(message="Please enter the appointment Date.")
	private LocalDate appointmentDate;
	@NotNull(message="Please enter the slot.")
	private String slot;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public Integer getCoachId() {
		return coachId;
	}
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", coachId=" + coachId + ", userId=" + userId
				+ ", appointmentDate=" + appointmentDate + ", slot=" + slot + "]";
	}
	
	
}
