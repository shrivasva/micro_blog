package poc.vivek.otts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OttsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttsApplication.class, args);
	}

}
