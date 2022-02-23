package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaServi {
	void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria2(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarPorNumero(String numero);
	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
}
