package com.nullptrexception.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplicationexclude = { SecurityConfig.class }
@EnableJpaRepositories(basePackages = "com.nullptrexception.backend.repositories")
@EntityScan(basePackages = "com.nullptrexception.backend.entity")
@ComponentScan(basePackages = {"com.nullptrexception.backend.Controller"})
public class ZkupdaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZkupdaterApplication.class, args);
	}

}
