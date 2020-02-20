package com.springwebflux.demo.WebfluxMongoClientDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.sql.SQLOutput;

@SpringBootApplication
public class WebfluxMongoClientDemoApplication {

	@Bean
	WebClient webClient(){
		return  WebClient.create("http://localhost:8099/rest/employee");
	}

	@Bean
	CommandLineRunner commandLineRunner(WebClient webClient){
		return  strings -> {
			webClient.get()
					.uri("/all")
					.retrieve()
					.bodyToFlux(Employee.class)
					.filter(employee -> employee.getName().equals("Ganguly"))
					.flatMap(employee -> {
						return webClient.get()
								.uri("/{id}/events", employee.getId())
								.retrieve()
								.bodyToFlux(EmployeeEvents.class);

					}).subscribe(System.out::println);
		};
	};

	public static void main(String[] args) {
		SpringApplication.run(WebfluxMongoClientDemoApplication.class, args);
	}

}
