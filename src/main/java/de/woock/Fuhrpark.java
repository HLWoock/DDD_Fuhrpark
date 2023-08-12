package de.woock;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.woock.domain.VorgaengeBoard;

@SpringBootApplication
public class Fuhrpark {
	
	public static VorgaengeBoard  vorgaengeBoard;

	public static void main(String[] args) {
		SpringApplication.run(Fuhrpark.class, args);
	}
	
	@Bean
	public ApplicationRunner test(VorgaengeBoard vorgaengeBoard) {
		return args -> {
			Fuhrpark.vorgaengeBoard  = vorgaengeBoard;
		};
	}
}

