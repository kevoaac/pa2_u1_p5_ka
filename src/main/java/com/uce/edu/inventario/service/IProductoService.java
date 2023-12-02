package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface IProductoService {
    public Producto buscar(String codigoBarras);
    public void guardar(Producto producto);
    public void actualizar(Producto producto);
    public void eliminar(String codigoBarras);
}
