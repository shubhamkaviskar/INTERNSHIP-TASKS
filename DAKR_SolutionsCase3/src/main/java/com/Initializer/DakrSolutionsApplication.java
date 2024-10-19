package com.Initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class DakrSolutionsApplication {
	
	private static final Logger logger = LogManager.getLogger(DakrSolutionsApplication.class);

	public static void main(String[] args) {
		logger.info("Main App Running");
		SpringApplication.run(DakrSolutionsApplication.class, args);
	}

}
