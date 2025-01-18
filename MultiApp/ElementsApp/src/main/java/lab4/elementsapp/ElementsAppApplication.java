package lab4.elementsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ElementsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElementsAppApplication.class, args);
	}

}
