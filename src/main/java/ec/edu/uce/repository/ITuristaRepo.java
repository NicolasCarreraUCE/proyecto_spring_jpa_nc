package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Turista;

public interface ITuristaRepo {
	void guardarTurista(Turista turista);
	List<Turista> obtenerListaTuristas();
}
