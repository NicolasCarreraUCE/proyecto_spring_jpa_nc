package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaRepo {

	void insertarGuardia(Guardia guardia);
	void actualizarGuardia(Guardia guardia);
	Guardia buscarGuardiaPorId(Integer id);
	void borrarGuardiaPorId(Integer id);
	
	
	Guardia buscarGuardiaPorApellido(String apellido);
	
	Guardia buscarGuardiaPorApellidoLista(String apellido);
	
	Guardia buscarGuardiaPorApellidoType(String apellido);
	
	Guardia buscarGuardiaPorApellidoNamed(String apellido);
	
	Guardia buscarGuardiaPorApellidoNative(String apellido);
	
}
