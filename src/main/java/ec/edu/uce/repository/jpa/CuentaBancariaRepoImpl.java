package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public void actualizarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero =:numero", CuentaBancaria.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}


}
