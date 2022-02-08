package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.repository.jpa.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepo facturaRepo;
	
	@Override
	public void insertarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.insertarFactura(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOIN(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaJOIN(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINLEFT(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaJOINLEFT(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaWHERE(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaWHERE(fecha);
	}

}
