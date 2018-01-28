package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PluralsightSpringcloudM1StartupApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM1StartupApplication.class, args);
	}
	
	@RequestMapping(value="/greeting", method=GET)
	public String sayHello() {
		return "Hello from Spring Boot!";
	}
}
