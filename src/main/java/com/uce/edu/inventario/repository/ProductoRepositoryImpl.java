package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository{
    private static List<Producto> bd=new ArrayList<>();

    @Override
    public Producto seleccionar(String codigoBarras) {
        for (Producto m: bd) {
            if (m.getCodigoBarras().equals(codigoBarras)) {
                Producto productoNuevo= new Producto();
                productoNuevo.setCodigoBarras(m.getCodigoBarras());
                productoNuevo.setNombre(m.getNombre());
                productoNuevo.setStock(m.getStock());
                return productoNuevo;
            }
        }
        return null;
    }
    public Producto seleccionarEliminar(String codigoBarras) {
        System.out.println("Seleccionamos: " + codigoBarras);
        for (Producto m:bd) {
            if (m.getCodigoBarras().equals(codigoBarras)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void insertar(Producto producto) {
        bd.add(producto);
        System.out.println("Se ha insertado: "+ producto );

    }

    @Override
    public void actualizar(Producto producto) {
        this.eliminar(producto.getCodigoBarras());
        this.insertar(producto);
        System.out.println("Se ha actualizado: " +
                producto);
    }

    @Override
    public void eliminar(String codigoBarras) {
        Producto m= this.seleccionarEliminar(codigoBarras);
        bd.remove(m);
        System.out.println("Se ha borrado: " + codigoBarras);

    }
}