package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventarioRepositoryImpl implements IInventarioRepository{
    private static List<Inventario> base = new ArrayList<>();
    @Override
    public Inventario seleccionar(String codigo) {
        for(Inventario inventario:base) {
            if (inventario.getCodigo().equals(codigo)) {
                Inventario invent = new Inventario();
                invent.setBodega(invent.getBodega());
                invent.setCodigo(invent.getCodigo());
                invent.setProducto(invent.getProducto());
                invent.setFechaIngreso(invent.getFechaIngreso());

                return invent;
            }
        }
        return null;
    }

    @Override
    public void insertar(Inventario inventario) {
        base.add(inventario);
    }

    @Override
    public void actualizar(Inventario inventario) {
        this.eliminar(inventario.getCodigo());
        this.insertar(inventario);
    }

    public Inventario seleccionarEliminar(String codigo) {
        for(Inventario inventario:base) {
            if (inventario.getCodigo().equals(codigo)) {
                return inventario;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String codigo) {
        Inventario inventario = this.seleccionarEliminar(codigo);
        base.remove(inventario);
    }
}
