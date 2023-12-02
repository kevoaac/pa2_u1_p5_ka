package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository{

    private static List<Bodega> base = new ArrayList<>();
    @Override
    public Bodega seleccionar(String codigo) {
        for(Bodega bodega:base) {
            if (bodega.getCodigo().equals(codigo)) {
                Bodega bod = new Bodega();
                bod.setCodigo(bodega.getCodigo());
                bod.setCapacidad(bodega.getCapacidad());
                bod.setDireccion(bodega.getDireccion());
                bod.setNombre(bodega.getNombre());

                return bod;
            }
        }
        return null;
    }

    @Override
    public void insertar(Bodega bodega) {
        base.add(bodega);
    }

    @Override
    public void actualizar(Bodega bodega) {
        this.eliminar(bodega.getCodigo());
        this.insertar(bodega);
    }

    public Bodega seleccionarEliminar(String codigo) {
        for(Bodega bodega:base) {
            if (bodega.getCodigo().equals(codigo)) {
                return bodega;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String codigo) {
        Bodega bodega  = this.seleccionarEliminar(codigo);
        base.remove(bodega);
    }
}
