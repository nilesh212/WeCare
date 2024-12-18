# Wecare Healthcare Application

Wecare is a Java Spring Boot application designed to simplify healthcare management by enabling users to book, reschedule, and manage appointments with healthcare professionals, called coaches. With secure user and coach authentication, and streamlined APIs, the app ensures a smooth and efficient booking experience.

## Features

- User registration and login
- Coach registration and login
- Profile management for users and coaches
- Booking, rescheduling, and cancellation of appointments

## API Endpoints

### User Endpoints
- **Register User:** `POST /users`
- **Login User:** `POST /users/login`
- **Get User Profile:** `POST /users/{userId}`
- **Book Appointment:** `POST /users/{userId}/booking/{coachId}`
- **Get All Appointments for a User:** `GET /users/booking/{userId}`

### Coach Endpoints
- **Register Coach:** `POST /coaches`
- **Login Coach:** `POST /coaches/login`
- **Get Coach Profile:** `POST /coaches/{coachId}`
- **Get All Coaches:** `GET /coaches/all`
- **Get All Appointments for a Coach:** `POST /coaches/booking/{coachId}`

### Booking Endpoints
- **Reschedule an Appointment:** `PUT /booking/{bookingId}`
- **Cancel an Appointment:** `DELETE /booking/cancel/{bookingId}`

## Technology Stack

- **Database:** MySQL
- **Backend Language:** Java
- **Framework:** Spring Boot

## Database Tables

1. **User:** Stores user details
2. **Coach:** Stores coach details
3. **Booking:** Stores appointment details

## Getting Started

### Prerequisites
- Java Development Kit
- MySQL Database
- Git

### Installation

1. Clone the repository
```bash
git clone https://github.com/nilesh212/wecare.git
```

2. Set up the MySQL database with the required schema

3. Configure database connection properties in `application.properties`

4. Build and run the application
```bash
./mvnw spring-boot:run
```

## Contribution Guidelines

1. Fork the repository
2. Create a feature branch
```bash
git checkout -b feature-name
```
3. Commit your changes
```bash
git commit -m 'Add feature'
```
4. Push to the branch
```bash
git push origin feature-name
```
5. Create a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please reach out to the project maintainers.
