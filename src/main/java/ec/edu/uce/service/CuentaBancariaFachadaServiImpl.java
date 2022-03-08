package ec.edu.uce.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaFachadaServiImpl {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaFachadaServiImpl.class);
	
	@Autowired
	private ICuentaBancariaServi cuaBancariaServi;
	
	public void realizarTransferenciaExpressInicialNoT(String cuentaOrigen, String cuentaDestino, BigDecimal valorTransferir) {
		LOG.info("Prueba 1: ");
		this.cuaBancariaServi.realizarTransferenciaExpres(cuentaOrigen, cuentaDestino, valorTransferir);
	}
}
