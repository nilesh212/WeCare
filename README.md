Wecare Healthcare Application

Wecare is a healthcare application that facilitates users in booking appointments with doctors, who are referred to as coaches in the application.

Description

Wecare is a Java Spring Boot application designed to simplify healthcare management by enabling users to book, reschedule, and manage appointments with healthcare professionals, called coaches. With secure user and coach authentication, and streamlined APIs, the app ensures a smooth and efficient booking experience.

Features

User registration and login.

Coach registration and login.

Profile management for users and coaches.

Booking, rescheduling, and cancellation of appointments.

API Endpoints

User

Register User: POST /users

Login User: POST /users/login

Get User Profile: GET /users/{userId}

Book Appointment: POST /users/{userId}/booking/{coachId}

Get All Appointments for a User: GET /users/booking/{userId}

Coach

Register Coach: POST /coaches

Login Coach: POST /coaches/login

Get Coach Profile: GET /coaches/{coachId}

Get All Coaches: GET /coaches/all

Get All Appointments for a Coach: GET /coaches/booking/{coachId}

Booking

Reschedule an Appointment: PUT /booking/{bookingId}

Cancel an Appointment: DELETE /booking/cancel/{bookingId}

Technology Stack

Database: MySQL

Backend Language: Java

Framework: Spring Boot

Database Tables

User: Stores user details.

Coach: Stores coach details.

Booking: Stores appointment details.

Instructions for Running the Application

Clone the repository from GitHub.

Set up the MySQL database with the required schema.

Configure the database connection properties in the application.properties file.

Build and run the application using your preferred IDE or command line.

Contribution Guidelines

Fork the repository.

Create a feature branch (git checkout -b feature-name).

Commit your changes (git commit -m 'Add feature').

Push to the branch (git push origin feature-name).

Create a pull request.

License

This project is licensed under the MIT License. See the LICENSE file for details.
