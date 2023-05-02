package com.timesheet.timesheet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class TimesheetApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(TimesheetApplication.class, args);
		//log.info("Application was started... in {} Environment ",context.getEnvironment().getProperty("environment"));
		log.info("Application was started... in DB {} User ",context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
