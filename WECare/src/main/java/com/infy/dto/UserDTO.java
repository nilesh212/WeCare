package com.infy.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class UserDTO {

	private Integer userId;
	@NotNull(message="Please enter the Name.")
	@Pattern(regexp="^.{3,50}$",message="Name length should be between 3 to 50.")
	private String name;
	private String gender;
	private LocalDate dateOfBirth;
	@NotNull(message="Please enter the password.")
	@Pattern(regexp="^.{5,10}$",message="Password length should be between 5 to 10.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@NotNull(message="Please enter your password in Confirm Password field.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String confirmPassword;
	@NotNull(message="Please enter mobile number!")
	@Digits(integer=10,fraction=0,message="Mobile number should be of 10 digits only.")
	private Long mobileNumber;
	@NotNull(message="Please enter Email Id.")
	@Email(message="Please enter valid mail id.")
	private String email;
	@NotNull(message="Please enter Pincode!")
	@Digits(integer=6,fraction=0,message="Pincode should be of 6 digits only.")
	private Integer pincode;
	@NotNull(message="Please enter the City.")
	@Pattern(regexp="^.{3,20}$",message="City length should be between 3 to 20.")
	private String city;
	@NotNull(message="Please enter the State.")
	@Pattern(regexp="^.{3,20}$",message="State length should be between 3 to 20.")
	private String state;
	@NotNull(message="Please enter the Country.")
	@Pattern(regexp="^.{3,20}$",message="Country length should be between 3 to 20.")
	private String country;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	
	
}
