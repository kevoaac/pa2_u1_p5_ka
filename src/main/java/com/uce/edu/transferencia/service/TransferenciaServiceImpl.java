package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
    @Autowired
    private ITransferenciaRepository iTransferenciaRepository;

    @Autowired
    private ICuentaBancariaRepository bancariaRepository;
    @Override
    public Transferencia buscar(String numero) {
        return this.iTransferenciaRepository.seleccionar(numero);
    }

    @Override
    public void guardar(Transferencia transferencia) {
        this.iTransferenciaRepository.insertar(transferencia);
    }

    @Override
    public void actualizar(Transferencia transferencia) {
        this.iTransferenciaRepository.actualizar(transferencia);
    }

    @Override
    public void eliminar(String numero) {
        this.iTransferenciaRepository.eliminar(numero);
    }

    @Override
    public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
        // 1. Buscar Cta Origen
        CuentaBancaria ctaOrigen = this.bancariaRepository.seleccionar(numeroOrigen);
        // 2. Consultar el saldo
        // 3. Validar el saldo
        // 4. Restar el monto
        // 5. Actualizar Cta Origen

        // 6. Buscar Cta Destino
        // 7. Consultar saldo
        // 8. Sumar el monto
        // 9. Actualizar Cta Destino

        // 10. Crear la transferencia
    }

}
