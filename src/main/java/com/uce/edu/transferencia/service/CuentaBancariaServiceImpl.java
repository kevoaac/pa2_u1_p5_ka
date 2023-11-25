package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository bancariaRepository;
    @Override
    public CuentaBancaria buscar(String numero) {
        return this.bancariaRepository.seleccionar(numero);
    }

    @Override
    public void guardar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.insertar(cuentaBancaria);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.actualizar(cuentaBancaria);
    }

    @Override
    public void eliminar(String numero) {
        this.bancariaRepository.eliminar(numero);
    }
}
