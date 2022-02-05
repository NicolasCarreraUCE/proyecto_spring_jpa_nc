package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "emplado")
public class Empleado {

	@Id
	@Column(name = "empl_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado") // General el id aprtir de una secuancia
	@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", allocationSize = 1)
	private Integer id;
	
	@Column(name = "empl_iess")
	private String iess;
	
	@Column(name = "empl_salario")
	private BigDecimal salario;
	
	@OneToOne
	@JoinColumn(name = "empl_id_ciudadano")
	private Ciudadano ciudadano;

	// SET-GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	
	public String getIess() {
		return iess;
	}

	public void setIess(String iess) {
		this.iess = iess;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
}
