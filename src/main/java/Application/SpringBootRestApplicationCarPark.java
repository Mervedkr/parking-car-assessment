package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
 * 
 * @author  Merve Döker
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBootRestApplicationCarPark {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplicationCarPark.class, args);
	}

}


