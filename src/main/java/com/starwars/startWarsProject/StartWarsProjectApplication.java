package com.starwars.startWarsProject;

import com.starwars.startWarsProject.model.ResistenceSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartWarsProjectApplication {
	public static ResistenceSystem resistenceSystem = new ResistenceSystem();
	public static void main(String[] args) {
		SpringApplication.run(StartWarsProjectApplication.class, args);
	}
}
