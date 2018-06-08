package com.techstack;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringCookBook1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCookBook1Application.class, args);
	}
	
	@Scheduled(initialDelay=1000,fixedRate=3000)
	public void run() {
		System.out.println("Current time is: " +Calendar.getInstance().getTime());
	}
}
