package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.repository.jpa.ICiudadanoRepo;

@Service
public class CiudadanoServiImpl implements ICiudadanoServi {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Override
	public void insertarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.insertarCiudadano(ciudadano);
	}

}
