package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;

public interface IFacturaService {

	public void insertarFactura(Factura factura);
	
	List<Factura> buscarPorFechaJOIN(LocalDateTime fecha);
	List<Factura> buscarPorFechaJOINLEFT(LocalDateTime fecha);
	
	List<Factura> buscarPorFechaWHERE(LocalDateTime fecha);
	
	List<Factura> buscarPorFechaJOINFETCH(LocalDateTime fecha);

	List<FacturaSencilla> buscarPorFechaSencilla(LocalDateTime fecha);
}
