package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Empleado;

@Repository
@Transactional
public class EmpleadoServiceImpl implements IEmpleadoRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

}
