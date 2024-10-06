package com.fieclweb.jpa;

import com.fieclweb.jpa.models.Author;
import com.fieclweb.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean // NOTE: Beans should always be 'public'
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository
	) {
		return args -> {
			var author = Author.builder()
					.firstName("Saki")
					.lastName("Tenma")
					.age(34)
					.email("sakitenma@mail.com")
					.build();
			repository.save(author);
		};
	}

}
