package ec.edu.uce.repository.jpa;


import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaRepo {
	void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria);
	void actualizarCuentaBancaria2(CuentaBancaria cuentaBancaria);
	CuentaBancaria buscarPorNumero(String numero);
}
