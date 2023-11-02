# Simple Book Management System

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Additional Features](#additional-features)
- [Optional Features](#optional-features)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## Overview

The Simple Book Management System is a RESTful web service built with Spring Boot. It allows users to manage a collection of books and includes user management with authentication, user roles, and features such as password change, forgot password, and more.

## Prerequisites
 - JDK 17
- Gradle 8.1.1
- Sprint Boot 3.0.6
- An IDE  IntelliJ IDEA for the development
- A database ( MySQL)
- Postman or similar tools for testing the API

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/simple-book-management-system.git
   ```

2. Build the project using Maven (or Gradle if preferred):
   ```bash
   cd simple-book-management-system
   mvn clean install
   ```

3. Run the application:
   ```bash
   java -jar target/simple-book-management-system.jar
   ```

## Configuration

- Configure your database connection in `application.properties`.

- Update security configurations, such as JWT secret and token expiration, in `application.properties`.

## Usage

- Access the API using your favourite REST client (e.g., Postman):

  Base URL: `http://localhost:8084/api`

- Register a new user, authenticate, and access the book management and user profile endpoints as described in the API Endpoints section below.

 
## API Endpoints

- /user/register

    - Method: POST  
    - Full Path 
    
     `http://localhost:8084/users/register`
    
    - Input 
  
    `{
    "username": "Ariful556",
    "password": "123456",
    "fullName": "Md Ariful Islam",
    "email": "ashik@gmail.com",
    "dateRegistered": "2023-11-03T00:00:00.000+00:00",
    "role": "USER" // or "ADMIN" for an admin user
}`

<br>

- /user/login

    - Method: POST  
    - Full Path 
    
     `http://localhost:8080/auth-server/login`

  - Input 
    `{
    "email": "ashik@gmail.com",
    "password": "123456"
    }`

  - Output For Successful Login
  
    `{
    "data": {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6WyJBRE1JTiIsIlVTRVIiXSwic3ViIjoicmFoYXRpYm5ob3NzYWluQGdtYWlsLmNvbSIsImlhdCI6MTY4NjE5NDYyOSwiZXhwIjoxNjg2MTk2MDY5fQ.XS-nJvncEOwbkZAlgNGWO0-BhZFEYZ-6-duS5AZXnkE"
    }
}`

<br>

  - `GET /api/users/profile`: Retrieve the authenticated user's profile.
    <br>
  - `PUT /api/users/profile`: Update the profile of the authenticated user.

<hr>
<br>

- Book Management:
  - Add, update, and delete books (authentication required).
  - View the list of books and details of a specific book.

## Additional Features

- JWT-based authentication with Spring Security.
- Password change for users.
- Basic validation for user details during registration (e.g., email format, password complexity).
- Global exception handling for common exceptions.

## Optional Features

- Personal collection of books for users.
- Role-based access control (e.g., 'admin' role for certain operations).
- Forgot password mechanism for password reset via registered email.

## Project Structure

- Describe your project's directory structure, major components, and packages.

## Contributing

- Describe how others can contribute to your project.

Feel free to tailor this README to your project's specific details and structure. Additionally, include any information that is relevant to your project, such as the technology stack, project dependencies, or specific usage instructions.
