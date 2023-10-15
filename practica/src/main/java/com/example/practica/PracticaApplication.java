package com.example.practica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaApplication {
	private static Logger logger = LoggerFactory.getLogger(PracticaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
		logger.info("Esto es un info");
		logger.warn("Esto es un warning");
		logger.error("Esto es un error");
		logger.debug("Esto es un debug");
	}

}