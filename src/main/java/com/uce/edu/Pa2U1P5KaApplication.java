package com.uce.edu;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5KaApplication implements CommandLineRunner{
	
	@Autowired // Inyectar dependencia
	private Estudiante estudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.estudiante.setNombre("Kevin");
		this.estudiante.setApellido("Andrade");
		this.estudiante.setCedula("0402068555");
		this.estudiante.setSalario(new BigDecimal(100));
		
		System.out.println(estudiante);
		
	}

}
