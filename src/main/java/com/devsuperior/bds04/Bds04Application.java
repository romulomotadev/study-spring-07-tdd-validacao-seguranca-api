package com.devsuperior.bds04;

import com.devsuperior.bds04.config.SecurityBeansConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Bds04Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bds04Application.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {

		String securityConfig = passwordEncoder.encode("123456");
		System.out.println(securityConfig);

	}
}
