package com.uce.edu;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@SpringBootApplication
public class Pa2U1P5KaApplication implements CommandLineRunner{
	
	@Autowired // Inyectar dependencia
	private IMateriaService iMateriaService;
	
	@Autowired
	private Materia materia;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5KaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.materia.setCodigo("M1");
		this.materia.setNombre("P. Avanzada");
		this.materia.setNumeroCreditos(10);
		
		this.iMateriaService.registrar(materia);
		
		System.out.println("Imprimiendo reporte");
		List<Materia> reporte = this.iMateriaService.seleccionarTodos();
		reporte.forEach(System.out::println);
		
		
		Materia mate = this.iMateriaService.buscar("M1");
		System.out.println(mate);
		
		mate.setNumeroCreditos(20);
		
		this.iMateriaService.actualizar(mate);
		mate = this.iMateriaService.buscar("M1");
		System.out.println(mate);
		
		this.iMateriaService.eliminar("M1");
		
		mate = this.iMateriaService.buscar("M1");
		System.out.println(mate);
		System.out.println("Test");

	}

}
