package com.ai.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//, SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BeApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeApplication.class, args);
	}

}
