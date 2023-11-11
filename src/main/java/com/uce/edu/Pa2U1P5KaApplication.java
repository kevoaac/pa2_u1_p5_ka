package com.uce.edu;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5KaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		System.out.println("Hola soy kevin Andrade");
		System.out.println("Cambio en la misma rama main");
		System.out.println("Cambio para rama taller4");
		System.out.println("taller4V2");
		
	}

}
