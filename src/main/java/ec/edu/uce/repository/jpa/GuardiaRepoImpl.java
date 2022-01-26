package ec.edu.uce.repository.jpa;

import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

	@Override
	public Guardia buscarGuardiaPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		Query miQuery = entityManager.createNamedQuery("Guardia.buscarPorApellidoNative", Guardia.class);
		miQuery.setParameter("valor", apellido);
		return (Guardia) miQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCiteriAPI(String apellido) {
		// TODO Auto-generated method stub
		CriteriaBuilder miCriteria = this.entityManager.getCriteriaBuilder(); // como va a trabajar
		CriteriaQuery<Guardia> miQuery = miCriteria.createQuery(Guardia.class); // resultadi del Query
		
		// select * from Tabla where
		// Aquei se empieza a construir el SQL
		Root<Guardia> miTabla = miQuery.from(Guardia.class);  
		// Los WHERE  en criteria API se los conoce como Predicado
		javax.persistence.criteria.Predicate p1 = miCriteria.equal(miTabla.get("apellido"), apellido);
		
		// empesamos a confromar el select
		miQuery.select(miTabla).where(p1);
		
		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCiteriAPIAnd(String apellido, String edificio) {
		// TODO Auto-generated method stub
		CriteriaBuilder miCriteria = this.entityManager.getCriteriaBuilder(); // como va a trabajar
		CriteriaQuery<Guardia> miQuery = miCriteria.createQuery(Guardia.class); // resultadi del Query
		
		// select * from Tabla where
		// Aquei se empieza a construir el SQL
		Root<Guardia> miTabla = miQuery.from(Guardia.class);  
		// Los WHERE  en criteria API se los conoce como Predicado
		javax.persistence.criteria.Predicate p1 = miCriteria.equal(miTabla.get("apellido"), apellido);
		javax.persistence.criteria.Predicate p2 = miCriteria.equal(miTabla.get("edificio"), edificio);
		
		// empesamos a confromar el select
		miQuery.select(miTabla).where(p1,p2); // aplica en and por defecto
		
		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}

	@Override
	public Guardia buscarGuardiaPorApellidoCiteriAPIOr(String apellido, String edificio) {
		// TODO Auto-generated method stub
		CriteriaBuilder miCriteria = this.entityManager.getCriteriaBuilder(); // como va a trabajar
		CriteriaQuery<Guardia> miQuery = miCriteria.createQuery(Guardia.class); // resultadi del Query
		
		// select * from Tabla where
		// Aquei se empieza a construir el SQL
		Root<Guardia> miTabla = miQuery.from(Guardia.class);  
		// Los WHERE  en criteria API se los conoce como Predicado
		javax.persistence.criteria.Predicate p1 = miCriteria.equal(miTabla.get("apellido"), apellido);
		javax.persistence.criteria.Predicate p2 = miCriteria.equal(miTabla.get("edificio"), edificio);
		javax.persistence.criteria.Predicate predicadoFinal = miCriteria.or(p1,p2);
		
		// empesamos a confromar el select
		miQuery.select(miTabla).where(predicadoFinal);
		
		TypedQuery<Guardia> typedQuery = this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}
	
}
