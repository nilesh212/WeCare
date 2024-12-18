package com.infy.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id")
	private Integer bookingId;
	@ManyToOne
	@JoinColumn(name="coach_id",nullable=false)
	private Coach coach;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	@Column(name="appointment_date")
	private LocalDate appointmentDate;
	private String slot;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		return "Booking [bookingId=" + bookingId + ", coach=" + coach + ", user=" + user + ", appointmentDate="
				+ appointmentDate + ", slot=" + slot + "]";
	}
	
	
	
	
}
