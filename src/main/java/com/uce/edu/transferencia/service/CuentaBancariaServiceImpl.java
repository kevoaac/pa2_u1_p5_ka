package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    public void depositar(CuentaBancaria cuenta,  BigDecimal monto){
        CuentaBancaria cta = this.bancariaRepository.seleccionar(cuenta.getNumero());
        cta.setNumero(cuenta.getNumero());
        cta.setCedulaPropietario(cuenta.getCedulaPropietario());
        cta.setSaldo(descontarPorcentaje(monto));
        this.bancariaRepository.actualizar(cta);
    }

    public BigDecimal descontarPorcentaje(BigDecimal monto){
        return monto.multiply(new BigDecimal("0.9"));
    }

}
