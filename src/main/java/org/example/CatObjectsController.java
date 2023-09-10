package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CatObjectsController {
	@Bean
	public Cat createCat(){
		return new Cat();
	}

	@Bean
	@Primary
	public Cat createColoredCat(){
		return new Cat("Blue");
	}
}
