package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Empleado;
import ec.edu.uce.repository.jpa.IEmpleadoRepo;

@Service
public class EmpleadoServiImpl implements IEmpleadoServi {

	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	@Override
	public void insertarEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertarEmpleado(empleado);
	}

}
