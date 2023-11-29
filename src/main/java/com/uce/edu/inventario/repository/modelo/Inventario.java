package com.uce.edu.inventario.repository.modelo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Inventario {
    private String codigo;
    private LocalDateTime fechaIngreso;
    private Bodega bodega;
    private Producto producto;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "fechaIngreso=" + fechaIngreso +
                ", bodega=" + bodega +
                ", producto=" + producto +
                '}';
    }
}
