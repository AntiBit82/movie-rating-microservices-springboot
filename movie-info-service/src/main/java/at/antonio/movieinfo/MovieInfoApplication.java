package at.antonio.movieinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient is not necessary as the client lib in the pom already registers the app as a client
public class MovieInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoApplication.class, args);
	}

}
