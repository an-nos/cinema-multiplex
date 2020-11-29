package agh.alleviation;

import agh.alleviation.presentation.CinemaApp;
//import agh.alleviation.service.MovieService;
//import agh.alleviation.service.UserService;
import agh.alleviation.service.MovieService;
import agh.alleviation.service.UserService;
import agh.alleviation.util.UserType;
import javafx.application.Application;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "agh.alleviation.persistence" })
@EntityScan(basePackages = { "agh.alleviation.model" })
public class AlleviationApplication {

	public static void main(String[] args) {
//		SpringApplication.run(AlleviationApplication.class, args);
		Application.launch(CinemaApp.class, args);
	}

	@Bean
	public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext) {
		return new SpringFxWeaver(applicationContext);
	}


	@Bean
	public CommandLineRunner demo(MovieService movieService, UserService userService) {
		return args -> {
			String name = "Erlang: The Movie";
			movieService.addMovie(name);
			System.out.println(movieService.findMovie(name));

			String userName = "Mike";
			String userMail = "mike@erlang.com";
			String login = "helloJoe";
			UserType type = UserType.ADMIN;

			System.out.println(userService.addUser(userName, login, userMail, type).getEmail());
			System.out.println(userService.getUserByLogin(login).nameProperty().get());


//			movieService.findMovie(name).subscribe(System.out::println);
		};
	}
}
