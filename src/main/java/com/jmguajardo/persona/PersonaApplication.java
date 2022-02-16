package com.jmguajardo.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.jmguajardo.persona.controllers", "com.jmguajardo.persona.services", "com.jmguajardo.persona.exceptions"})
@EntityScan("com.jmguajardo.persona.models.entities")
@EnableJpaRepositories("com.jmguajardo.persona.repositories")
public class PersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaApplication.class, args);
	}

}
