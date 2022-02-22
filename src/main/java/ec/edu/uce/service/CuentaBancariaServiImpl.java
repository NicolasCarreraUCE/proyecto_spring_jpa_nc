package ec.edu.uce.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.repository.jpa.FacturaRepoImpl;
import ec.edu.uce.repository.jpa.ICuentaBancariaRepo;

@Service
public class CuentaBancariaServiImpl implements ICuentaBancariaServi {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiImpl.class);
	
	@Autowired
	private ICuentaBancariaRepo cuentaBancariaRepo;
	
	@Override
	public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepo.insertarCuentaBancaria(cuentaBancaria);
	}

	@Override
	public void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaBancariaRepo.actualizarCuentaBancaria(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepo.buscarPorNumero(numero);
	}

	@Override
	@Transactional
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		// TODO Auto-generated method stub
		try {
			CuentaBancaria cbOrigen = this.buscarPorNumero(cuentaOrigen);
			CuentaBancaria cbDestino = this.buscarPorNumero(cuentaDestino);
			
			cbOrigen.setSaldo(cbOrigen.getSaldo().subtract(valorTransferir));
			cbDestino.setSaldo(cbDestino.getSaldo().add(valorTransferir));
			
			this.actualizarCuentaBancaria(cbOrigen);
			this.actualizarCuentaBancaria(cbDestino);
			
			throw new Exception();
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("Se produjo un error se va a ejecutar un ROLLBACK");
		}
	}
}
