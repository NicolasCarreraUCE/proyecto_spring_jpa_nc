package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(GuardiaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(guardia);
	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(guardia);
	}

	@Override
	public Guardia buscarGuardiaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Guardia.class, id);
	}

	@Override
	public void borrarGuardiaPorId(Integer id) {
		// TODO Auto-generated method stub
		Guardia guardiaBorrar = this.buscarGuardiaPorId(id);
		this.entityManager.remove(guardiaBorrar);
	}

	@Override
	public Guardia buscarGuardiaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// SQL: select * from guardia where gua_apellido=?
		// JPQL: select g from Guardia g where g.apellido=:valor
		Guardia miGuardia = null;
		try {
			Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
			miQuery.setParameter("valor", apellido);
			miGuardia = (Guardia) miQuery.getSingleResult();
				
		} catch (NoResultException e) {
			// TODO: handle exception
			LOG.error("No existe un resultado para: " + apellido, e);
		}
		return miGuardia;
	}

	@Override
	public Guardia buscarGuardiaPorApellidoLista(String apellido) {
		// TODO Auto-generated method stub
		// SQL: select * from guardia where gua_apellido=?
		// JPQL: select g from Guardia g where g.apellido=:valor
	
		Query miQuery = this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		java.util.List<Guardia> listaGuardias = miQuery.getResultList();
		
		if (!listaGuardias.isEmpty()) {
			LOG.info("Tiene mas de un reguistro: " + listaGuardias.size());
			return (Guardia) listaGuardias.get(0);
		} else {
			return null;
		}
	}

	
	/**
	 * Metodo buscarGuardiaPorApellido por TypeQuery
	 */
	@Override
	public Guardia buscarGuardiaPorApellidoType(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Guardia> myTypedQuerry = (TypedQuery<Guardia>) this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		myTypedQuerry.setParameter("valor", apellido);
		return myTypedQuerry.getSingleResult();
	}

	/**
	 * Metodo buscarGuardiaPorApellido por NamedQuery
	 */
	@Override
	public Guardia buscarGuardiaPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		Query miQuery = this.entityManager.createNamedQuery("Guardia.buscarPorApellido");
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		Query miQuery = this.entityManager.createNativeQuery("select * from guardia g where g.apellido=:valor",Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}
	
}
