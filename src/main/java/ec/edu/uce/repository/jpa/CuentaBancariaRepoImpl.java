package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.qos.logback.core.subst.Token.Type;
import ec.edu.uce.modelo.jpa.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		throw new ArrayIndexOutOfBoundsException();
	}
	
	@Override
	@Transactional(value = TxType.NEVER)
	public void enviarMail(String asunto) {
		LOG.info("Se envia MAIL con el asunto " + asunto);
	}
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizarCuentaBancaria2(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
//		try {
//			throw new ArrayIndexOutOfBoundsException();
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// TODO: handle exception
//			LOG.error("ERROR NO PROPAGADO");
//		}
		
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =:numero", CuentaBancaria.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}


}
