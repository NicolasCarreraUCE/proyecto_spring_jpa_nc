package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.service.GestorCitaServiceImpl;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoSpringJpaNcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoSpringJpaNcApplication.class);
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IGestorCitaService gestorCitaService;
	
	@Autowired
	private IGuardiaService guardiaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaNcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Paciente paciente1 = new Paciente();
//		paciente1.setId(2);
//		paciente1.setNombre("Nicolas");
//		paciente1.setApellido("Carrera");
//		paciente1.setEdad(25);
		//this.pacienteService.insertarNuevoPaciente(paciente1);
		
		//Paciente paciente1 = pacienteService.buscarPacientePorId(1);
		//System.out.println(paciente1);
		
		//this.pacienteService.borrarPacientePorId(3);
		
		//this.pacienteService.apctualizarPaciente(paciente1);
		
		//Paciente paciente2 = this.pacienteService.buscarPacientePorId(2);
		
		
		
//		Paciente p1 = new Paciente();
//		p1.setId(7);
//		p1.setNombre("Daniel");
//		p1.setApellido("Constante");
//		p1.setEdad(45);
//	
//		Receta r1 = new Receta();
//		r1.setId(2);
//		r1.setIndicaciones("Paracetamal cada 8 horas");
//		r1.setMedicamentos("Parecetamol 500g");
//		
//		this.gestorCitaService.registrarNuevaConsulata(p1, r1);
	
//		Guardia g1 = new Guardia();
//		g1.setNombre("Pepito");
//		g1.setApellido("Torres");
//		g1.setEdificio("Naciones Unidas");
		
		//this.guardiaService.guardarGuardia(g1);
	
//		Guardia g2 = new Guardia();
//		g2.setId(1);
//		g2.setNombre("Juanito");
//		g2.setApellido("Teran");
//		g2.setEdificio("Villaflora");
//		
//		this.guardiaService.actializarGuardia(g2);
	
//		Guardia g3 = this.guardiaService.buscarGuardia(1);
//		System.out.println(g3);
		
		//this.guardiaService.borrarGuardia(5);
		
//		Guardia gApellido = this.guardiaService.buscarPorApellido("Teran");
//		System.out.println(gApellido);
		
//		Guardia g4 = this.guardiaService.buscarGuardiaPorApellidoLista("Teran");
	
//		Guardia g5 = this.guardiaService.buscarGuardiaPorApellidoListaTyped("Teran");
	
//		Guardia g6 = this.guardiaService.buscarGuardiaPorApellidoListaNamed("Teran");
//		LOG.info("El guardia es: " + g5);
		
//		Guardia g7 = this.guardiaService.buscarGuardiaPorApellidoNative("Teran");
//		LOG.info(g7.toString());
		
//		Guardia g8 = this.guardiaService.buscarGuardiaPorApellidoNamedNative("Teran");
	
//		Guardia g9 = this.guardiaService.buscarGuardiaPorApellidoCiteriAPI("Teran");
//		LOG.info(g9.toString());
		
		Guardia g10 = this.guardiaService.buscarGuardiaPorApellidoCiteriAPIAnd("Teran","Villaflora");
		LOG.info(g10.toString());
		
		Guardia g11 = this.guardiaService.buscarGuardiaPorApellidoCiteriAPIOr("Teran","Edificio 1");
		LOG.info(g11.toString());
	}

}
