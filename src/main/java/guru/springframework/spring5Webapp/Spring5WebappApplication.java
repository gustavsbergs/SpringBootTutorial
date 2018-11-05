package guru.springframework.spring5Webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"guru.springframework"})
@SpringBootApplication
public class Spring5WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5WebappApplication.class, args);
	}
}
