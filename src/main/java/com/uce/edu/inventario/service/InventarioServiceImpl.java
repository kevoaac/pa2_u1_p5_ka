package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InventarioServiceImpl implements IInventarioService{
    @Autowired
    private IInventarioRepository iInventarioRepository;
    @Autowired
    private IBodegaRepository iBodegaRepository;
    @Autowired
    private IProductoRepository iProductoRepository;
    @Override
    public Inventario buscar(String codigo) {
        return this.iInventarioRepository.seleccionar(codigo);
    }

    @Override
    public void guardar(Inventario inventario) {
        this.iInventarioRepository.insertar(inventario);
    }

    @Override
    public void actualizar(Inventario inventario) {
        this.iInventarioRepository.actualizar(inventario);
    }

    @Override
    public void eliminar(String codigo) {
        this.iInventarioRepository.eliminar(codigo);
    }

    @Override
    public void registrar(String codigoBodega, String codigoBarras, Integer stock) {
        Bodega bodega = this.iBodegaRepository.seleccionar(codigoBodega);

        Producto producto = this.iProductoRepository.seleccionar(codigoBarras);
        Integer stockActual = producto.getStock();
        Integer stockFinal = stockActual + stock;
        producto.setStock(stockFinal);
        this.iProductoRepository.actualizar(producto);

        Inventario inventario = new Inventario();
        inventario.setCodigo("165126168");
        inventario.setFechaIngreso(LocalDateTime.now());
        inventario.setBodega(bodega);
        inventario.setProducto(producto);

        this.iInventarioRepository.insertar(inventario);


    }
}
