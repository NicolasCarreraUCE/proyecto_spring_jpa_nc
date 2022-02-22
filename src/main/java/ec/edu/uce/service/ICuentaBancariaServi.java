package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaServi {
	void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
}
