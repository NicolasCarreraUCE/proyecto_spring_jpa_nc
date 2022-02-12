package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Turista;
import ec.edu.uce.repository.ITuristaRepo;

@Service
public class TuristaServiImpl implements ITuristaService {

	@Autowired
	private ITuristaRepo turistaRepo;
	
	@Override
	public void guardarTurista(Turista turista) {
		// TODO Auto-generated method stub
		this.turistaRepo.guardarTurista(turista);
	}
	
	@Override
	public List<Turista> obtenerTodosTuristas() {
		// TODO Auto-generated method stub
		List<Turista> lista = this.turistaRepo.obtenerListaTuristas(); // que se obtienen del repository
		List<Turista> listaCalculada = this.calcualrSaldo(lista);
		return listaCalculada;
	}
	
	private List<Turista> calcualrSaldo(List<Turista> listaTurista) {
		for(Turista turista : listaTurista) {
			BigDecimal saldo = turista.getValor().subtract(turista.getAbono());
			turista.setSaldo(saldo);
		}
		return listaTurista;
	}

}
