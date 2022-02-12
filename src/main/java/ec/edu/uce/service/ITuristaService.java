package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Turista;

public interface ITuristaService {
	void guardarTurista(Turista turista);
	List<Turista> obtenerTodosTuristas();
}
