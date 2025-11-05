package es.etg.daw.dawes.java.rest.restfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // Activamos la caché
@SpringBootApplication
public class RestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullApplication.class, args);
	}

}
