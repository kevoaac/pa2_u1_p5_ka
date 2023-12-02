package com.uce.edu;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;
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
    private IProductoService iProductoService;
    @Autowired
    private IInventarioService iInventarioService;
    @Autowired
    private IBodegaService iBodegaService;

    public static void main(String[] args) {
        SpringApplication.run(Pa2U1P5KaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Producto p1 = new Producto();
        p1.setCodigoBarras("123455");
        p1.setNombre("HP 15 laptop");
        p1.setStock(0);

        Producto p2 = new Producto();
        p2.setCodigoBarras("654321");
        p2.setNombre("Impresora");
        p2.setStock(0);

        this.iProductoService.guardar(p1);
        this.iProductoService.guardar(p2);


        Bodega b1 = new Bodega();
        b1.setNombre("B1");
        b1.setDireccion("UCE");
        b1.setCapacidad(100);
        b1.setCodigo("53123");

        this.iBodegaService.guardar(b1);

        Inventario inventario = new Inventario();
        inventario.setProducto(p1);
        inventario.setBodega(b1);
        inventario.setFechaIngreso(LocalDateTime.now());
        inventario.setCodigo("i123");

        this.iInventarioService.registrar(b1.getCodigo(), p1.getCodigoBarras(), 50);
        this.iInventarioService.registrar(b1.getCodigo(), p2.getCodigoBarras(), 100);
        this.iInventarioService.registrar(b1.getCodigo(), p1.getCodigoBarras(), 20);

        System.out.println(">>Buscar Productos");
        System.out.println(this.iProductoService.buscar(p1.getCodigoBarras()));
        System.out.println(this.iProductoService.buscar(p2.getCodigoBarras()));


    }

}
