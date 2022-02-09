package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.repository.jpa.IDetalleFacturaRepo;

@Service
public class DetalleFacturaServiImpl implements IDetalleFacturaServi {

	@Autowired
	private IDetalleFacturaRepo detalleFacturaRepo;
	@Override
	public List<DetalleFactura> buscarProductos(BigDecimal valorMinimo, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.detalleFacturaRepo.buscarProductos(valorMinimo, fecha);
	}

}
