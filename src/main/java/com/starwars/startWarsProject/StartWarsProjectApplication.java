package com.starwars.startWarsProject;

import com.starwars.startWarsProject.model.ResistenceSystemDataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartWarsProjectApplication {
	public static ResistenceSystemDataBase resistenceSystemDataBase = new ResistenceSystemDataBase();

    public static void main(String[] args) {
		SpringApplication.run(StartWarsProjectApplication.class, args);
	}
}
