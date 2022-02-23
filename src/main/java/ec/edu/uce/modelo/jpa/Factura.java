package ec.edu.uce.modelo.jpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura") // General el id aprtir de una secuancia
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	private Integer id;
	
	@Column(name = "fact_numero")
	private String numero;
	
	@Column(name = "fact_cedula")
	private String cedula;
	
	@Column(name = "fact_fecha", columnDefinition = "TIMESTAMP") // Maneja la fecha y las horas
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL) // fetch = FetchType.EAGER - carga a los hijos
	private List<DetalleFactura> detalles;
	
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
//	@Override
//	public String toString() {
//		return "Factura [id=" + id + ", numero=" + numero + ", cedula=" + cedula + ", fecha=" + fecha + "]";
//	}
	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", cedula=" + cedula + ", fecha=" + fecha + ", detalles="
				+ detalles + "]";
	}

	// SET-GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
