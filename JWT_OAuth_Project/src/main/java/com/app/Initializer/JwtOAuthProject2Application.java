package com.app.Initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.Initializer.Repository.UserRepository;
import com.app.Initializer.entities.Role;
import com.app.Initializer.entities.User;

@SpringBootApplication
public class JwtOAuthProject2Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public void run(String... args) {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if (null == adminAccount) {
			User user = new User();
			user.setEmail("shubhamkaviskar@gmail.com");
			user.setName("admin");
			user.setSecondname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(JwtOAuthProject2Application.class, args);
	}
}
