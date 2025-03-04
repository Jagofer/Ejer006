package es.santander.ascender.ejerc_006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejerc006Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejerc006Application.class, args);
	}
	
@ContextConfiguration(classes = Ejerc_006Application.class)
@SpringBootTest(classes = Ejerc006Application.class)
public class ApplicationServiceTest {
	}
	
}
