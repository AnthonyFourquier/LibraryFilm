package fr.eni.movielibrary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MovieLibraryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieLibraryApplication.class, args);
	}

}
