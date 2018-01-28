package pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class PluralsightSpringcloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM3TaskApplication.class, args);
	}
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}
	
	public class TollProcessingTask implements CommandLineRunner {
		
		@Override
		public void run(String... tollingInfo) throws Exception {
			// parameters are station id, license plate, timestamp
			if(null != tollingInfo) {
				System.out.println("Parameter length is " + tollingInfo.length);
				
				String stationId = tollingInfo[1];
				String licensePlate = tollingInfo[2];
				String timestamp = tollingInfo[3];
				
				System.out.println("Station Id is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
			}
		}
		
	}
}
