package com.uce.edu.inventario.service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodegaServiceImpl implements IBodegaService{
    @Autowired
    private IBodegaRepository iBodegaRepository;
    @Override
    public Bodega buscar(String codigo) {
        return this.iBodegaRepository.seleccionar(codigo);
    }

    @Override
    public void guardar(Bodega bodega) {
        this.iBodegaRepository.insertar(bodega);
    }

    @Override
    public void actualizar(Bodega bodega) {
        this.iBodegaRepository.actualizar(bodega);
    }

    @Override
    public void eliminar(String codigo) {
        this.iBodegaRepository.eliminar(codigo);
    }
}
