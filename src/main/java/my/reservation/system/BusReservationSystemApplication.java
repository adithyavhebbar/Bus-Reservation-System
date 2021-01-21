package my.reservation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "hebbar.brs.DTO", "hebbar.brs.configuration", "hebbar.brs.controller",
		"hebbar.brs.entities", "hebbar.brs.models", "hebbar.brs.repositories", "hebbar.brs.services" })
@EnableJpaRepositories(basePackages = { "hebbar.brs.repositories" })
@EntityScan(basePackages = { "hebbar.brs.entities" })
public class BusReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusReservationSystemApplication.class, args);
	}

}
