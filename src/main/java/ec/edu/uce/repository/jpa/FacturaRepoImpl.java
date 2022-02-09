package ec.edu.uce.repository.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.ProyectoSpringJpaNcApplication;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;

// Existe una coneccion prestablecida con la base de datos
@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(FacturaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOIN(LocalDateTime fecha) {
		// Declaramos un typedQuery para no hacer un cast
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Factura> buscarPorFechaJOINLEFT(LocalDateTime fecha) {
		// Declaramos un typedQuery para no hacer un cast
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE f.fecha <=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		
		List<Factura> myLista = myQuery.getResultList();
		
		// Cosnulata bajo demanda
		LOG.info("Longuitud REPO " + myLista.size());
		for (Factura factura : myLista) {
			LOG.info("Detalles: " + factura.getDetalles());
			LOG.info(factura.toString());
		}
		return myLista;
	}

	@Override
	public List<Factura> buscarPorFechaWHERE(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND f.fecha <=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		
		List<Factura> myLista = myQuery.getResultList();
		
		// Cosnulata bajo demanda
		LOG.info("Longuitud REPO " + myLista.size());
		for (Factura factura : myLista) {
			LOG.info("Detalles: " + factura.getDetalles());
			LOG.info(factura.toString());
		}
		return myLista;
	}

	@Override
	public List<Factura> buscarPorFechaJOINFETCH(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE f.fecha <=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaSencilla> buscarPorFechaSencilla(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaSencilla> myQuery = this.entityManager.createQuery("SELECT NEW ec.edu.uce.modelo.jpa.FacturaSencilla(f.numero,f.cedula) FROM Factura f JOIN f.detalles d WHERE f.fecha <=:fecha", FacturaSencilla.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}

}
