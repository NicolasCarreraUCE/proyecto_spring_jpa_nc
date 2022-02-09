package ec.edu.uce.modelo.jpa;

public class FacturaSencilla {

	private String numero;
	private String cedula;
	
	public FacturaSencilla() {
		// TODO Auto-generated constructor stub
	}
	
	// Es mandatorio que se cree un constructor con los atributos
	public FacturaSencilla(String numero, String cedula) {
		super();
		this.numero = numero;
		this.cedula = cedula;
	}
	
	@Override
	public String toString() {
		return "FacturaSencilla [numero=" + numero + ", cedula=" + cedula + "]";
	}

	// SET-GET
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
	
}
