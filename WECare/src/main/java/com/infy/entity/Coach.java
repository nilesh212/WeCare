package com.infy.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coach {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coach_id")
	private Integer coachId;
	private String name;
	private String gender;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	private String password;
	@Column(name="mobile_number")
	private Long mobileNumber;
	private String speciality;
	
	public Integer getCoachId() {
		return coachId;
	}
	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", speciality=" + speciality + "]";
	}
	
	
}
