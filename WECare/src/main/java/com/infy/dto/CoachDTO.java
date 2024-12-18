package com.infy.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CoachDTO {
	private Integer coachId;
	@NotNull(message="Please enter the name.")
	@Pattern(regexp="^.{3,50}$",message="Name length should be between 3to 50.")
	private String name;
	private String gender;
	private LocalDate dateOfBirth;
	@NotNull(message="Please enter Password.")
	@Pattern(regexp="^.{5,10}$",message="Password length should be between 5 to 10.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@NotNull(message="Please enter the password in Confirm Password as well.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String confirmPassword;
	@NotNull(message="Please enter the mobile Number.")
	@Digits(integer=10,fraction=0,message="Mobile number should be of 10 digits only.")
	private Long mobileNumber;
	@NotNull(message="Please enter the name.")
	@Pattern(regexp="^.{3,50}$",message="Name length  should be between 3to 50.")
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
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
		return "CoachDTO [coachId=" + coachId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", mobileNumber=" + mobileNumber
				+ ", speciality=" + speciality + "]";
	}
	
	
}
