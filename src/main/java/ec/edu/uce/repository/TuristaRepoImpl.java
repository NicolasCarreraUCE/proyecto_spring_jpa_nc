package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Turista;

@Repository
@Transactional
public class TuristaRepoImpl implements ITuristaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardarTurista(Turista turista) {
		// TODO Auto-generated method stub
		this.entityManager.persist(turista);
	}

	@Override
	public List<Turista> obtenerListaTuristas() {
		// TODO Auto-generated method stub
		TypedQuery<Turista> myQuery = this.entityManager.createQuery("SELECT t FROM Turista t", Turista.class);
		
		return myQuery.getResultList();
	}

	

}
