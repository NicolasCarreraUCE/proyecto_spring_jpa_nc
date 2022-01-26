package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="guardia") // Este es absolulamente nesesarioo cuando la tabla tiene un nombre diferente
// Aqui se declara los NamedQuery de Guardia
@NamedQuery(name = "Guardia.buscarPorApellido", query = "select g from Guardia g where g.apellido=:valor")
@NamedNativeQuery(name = "Guardia.buscarPorApellidoNative", query = "select * from guardia g where g.apellido=:valor", resultClass = Guardia.class)
public class Guardia {

	@Id // Define la clave primaria
	@Column(name="id") // Relaciona el argumento con la columna de la base de datos

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guardia") // General el id aprtir de una secuancia
	@SequenceGenerator(name = "seq_guardia", sequenceName = "seq_guardia", allocationSize = 1)
	private Integer id;
	
	@Column(name="nombre") // Se puede omitir si tienen el mismo nombre como en este caso
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="edificio")
	private String edificio;
	
	// SET-GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	
	
}
