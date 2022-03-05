package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaServi {
	void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria2(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarPorNumero(String numero);
	void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);

	void realizarTransferenciaExpresInicial(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);

	void realizarTransferenciaExpresInicialNoT(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	
	void realizarTransferenciaExpres(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir);
	
	void propagacionMandatory();
	
	void enviarEmail();
	void enviarEmailNoT();
}
