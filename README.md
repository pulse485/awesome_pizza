# Awesome Pizza 

This is a simple project for managing pizza orders in a restaurant. It provides functionalities to place orders, track their status, and simulate order processing.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [Testing](#testing)


## Introduction

The Awesome Pizza Ordering System is a web-based application built using Spring Boot. It allows users to place pizza orders, which are then processed asynchronously in the background. Orders can be tracked by their status (Pending, In Progress, Completed), and users can retrieve order details by their unique ID.

## Features

- Place pizza orders
- Track order status
- Simulate order processing
- Retrieve order details by ID

## Technologies

- Java
- Spring Boot
- Mockito
- JUnit
- Maven

## Setup

1. Clone the repository:

   - git clone https://github.com/your-username/awesome-pizza.git

2. Navigate to the project directory:

   - cd awesome-pizza

3. Build the project using Maven:

   - mvn clean install

4. Run the application:

   - mvn spring-boot:run

## Usage
Open postman (or any rest client) and trigger the endpoint:  
    - to get and order: http://localhost:8080/api/orders/50e09e0e-f3c4-46e6-ab85-bfb2acbf20a0 (GET CALL) <br/>
    - to put a new order: http://localhost:8080/api/orders (POST CALL)

## Testing
 There are the junit in the relative test folder of the project
