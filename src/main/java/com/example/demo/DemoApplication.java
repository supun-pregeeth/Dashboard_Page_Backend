package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //factory rules and hiring staff
public class DemoApplication { // owner

//maven is a build and dependency management tool.

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); //factory start
		System.out.println("🚀 Application started successfully!");

}}

// controller - Request Handler
// Dto - Simple object to transfer data between layers (Controller → Service)
// service - Business Logic Layer
// entity(model) - Table Structure
// repo - Database Access Layer
// database

