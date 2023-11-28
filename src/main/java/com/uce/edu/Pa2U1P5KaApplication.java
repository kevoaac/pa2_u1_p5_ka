package com.uce.edu;


import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@SpringBootApplication
public class Pa2U1P5KaApplication implements CommandLineRunner {

    @Autowired
    private ITransferenciaService iTransferenciaService;
    @Autowired
    private ICuentaBancariaService bancariaService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U1P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Crear las cuentas
        // 1.1 Forma1
        CuentaBancaria ctaOrigen = new CuentaBancaria();
        ctaOrigen.setCedulaPropietario("987456321");
        ctaOrigen.setNumero("1234");
        ctaOrigen.setSaldo(new BigDecimal(100));
        this.bancariaService.guardar(ctaOrigen);

        // 1.2 Forma2
        CuentaBancaria ctaDestino = new CuentaBancaria();
        ctaDestino.setCedulaPropietario("987456333");
        ctaDestino.setNumero("5678");
        ctaDestino.setSaldo(new BigDecimal(200));
        this.bancariaService.guardar(ctaDestino);


        CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
        System.out.println(ctaOrigen1);
        CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
        System.out.println(ctaDestino1);

        // TODO Busqueda de la transferencia
        this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(10));
        this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(30));
        this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(60));

        System.out.println("\n>>Informe de transferencias");
        List< Transferencia > transferencias = this.iTransferenciaService.mostrarTodas();
        transferencias.forEach(System.out::println);

    }

}
