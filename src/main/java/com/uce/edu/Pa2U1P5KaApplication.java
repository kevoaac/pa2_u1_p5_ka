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
    // DI Mediante atributo
    @Autowired
    private ITransferenciaService iTransferenciaService;

    // DI Mediante constructor
    /*
    private ITransferenciaService iTransferenciaService;
    @Autowired
    public Pa2U1P5KaApplication(ITransferenciaService iTransferenciaService){
        this.iTransferenciaService = iTransferenciaService;
    }
     */

    // DI Mediante método set
    /*
    private ITransferenciaService iTransferenciaService;
    @Autowired
    public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
        this.iTransferenciaService = iTransferenciaService;
    }
     */

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

        this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(20));
        this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(50));


        CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
        System.out.println(ctaOrigen1);
        CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
        System.out.println(ctaDestino1);

        this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(50));
        this.iTransferenciaService.realizar("5678", "1234", new BigDecimal(20));

        // Reporte del estado de cuenta de todas las transferencias
        System.out.println("\n>>Informe de transferencias");
        List<Transferencia> transferencias = this.iTransferenciaService.mostrarTodas();

        int indice = 0;
        for (Transferencia transferencia : transferencias) {
            indice++;
            System.out.println("[" + indice + "]" + ":" + transferencia);
        }
        //transferencias.forEach(System.out::println);

        // DESCONTAR FI DE DEPOSITO
        System.out.println("\n>>>Depositos con el 10% FI");
        CuentaBancaria miCuenta = new CuentaBancaria();
        miCuenta.setCedulaPropietario("17955456");
        miCuenta.setNumero("888");
        miCuenta.setSaldo(new BigDecimal(0));
        this.bancariaService.guardar(miCuenta);

        this.bancariaService.depositar("888", new BigDecimal(1000));
        CuentaBancaria cuentaActualizada = this.bancariaService.buscar("888");
        System.out.println(cuentaActualizada);

    }

}
