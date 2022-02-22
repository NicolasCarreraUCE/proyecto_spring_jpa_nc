package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.Turista;
import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Empleado;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencilla;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.ICiudadanoRepo;
import ec.edu.uce.repository.jpa.IEmpleadoRepo;
import ec.edu.uce.service.GestorCitaServiceImpl;
import ec.edu.uce.service.IClienteServi;
import ec.edu.uce.service.ICuentaBancariaServi;
import ec.edu.uce.service.IDetalleFacturaServi;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;
import ec.edu.uce.service.ITuristaService;

@SpringBootApplication
public class ProyectoSpringJpaNcApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoSpringJpaNcApplication.class);
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IGestorCitaService gestorCitaService;
	
	@Autowired
	private IGuardiaService guardiaService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Autowired
	private IEmpleadoRepo empleadoRepo;
	
	@Autowired
	private IDetalleFacturaServi detalleFacturaServi;
	
	@Autowired
	private IClienteServi clienteServi;
	
	@Autowired 
	private ITuristaService turistaService;
	
	@Autowired
	private ICuentaBancariaServi cuentaBancariaServi;
	
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
//		
//		Guardia g10 = this.guardiaService.buscarGuardiaPorApellidoCiteriAPIAnd("Teran","Villaflora");
//		LOG.info(g10.toString());
//		
//		Guardia g11 = this.guardiaService.buscarGuardiaPorApellidoCiteriAPIOr("Teran","Edificio 1");
//		LOG.info(g11.toString());
		
		// Factura
//		Factura miFactura = new Factura();
//		miFactura.setCedula("1727450684");
//		miFactura.setNumero("0001-2345-8601");
//		LocalDateTime miFecha = LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45);
//		miFactura.setFecha(miFecha);
//		
//		// Datalles
//		List<DetalleFactura> detalles = new ArrayList<>();
//		
//		// Primer detalle
//		DetalleFactura d1 = new DetalleFactura();
//		d1.setCantidad(2);
//		d1.setPrecio(new BigDecimal(2.75));
//		d1.setFactura(miFactura);
//		
//		DetalleFactura d2 = new DetalleFactura();
//		d2.setCantidad(10);
//		d2.setPrecio(new BigDecimal(10.50));
//		d2.setFactura(miFactura);
//		
//		detalles.add(d1);
//		detalles.add(d2);
//		
//		miFactura.setDetalles(detalles);
//		
//		this.facturaService.insertarFactura(miFactura);
//		
//		
//		Empleado empleado = new Empleado();
//		empleado.setSalario(new BigDecimal(100.0));
//		empleado.setIess("qwe");
//		
//		
//		Ciudadano ciudadano = new Ciudadano();
//		ciudadano.setNombre("Nicolas");
//		ciudadano.setApellido("Carrera");
//		
//		empleado.setCiudadano(ciudadano);
//		
//		ciudadano.setEmpleado(empleado);
//		
//		this.ciudadanoRepo.insertarCiudadano(ciudadano);
//	
//		List<Factura> listaFactura = this.facturaService.buscarPorFechaJOIN(LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));
//	
//		List<Factura> listaFacturaL = this.facturaService.buscarPorFechaJOINLEFT(LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));	
//		
//		List<Factura> listaFacturaW = this.facturaService.buscarPorFechaWHERE(LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));	
//		
//		for(Factura factura : listaFactura) {
//			LOG.info(factura.toString());
//		}
//		
//		for(Factura factura : listaFacturaL) {
//			LOG.info(factura.toString());
//		}
//		
//		for(Factura factura : listaFacturaW) {
//			LOG.info(factura.toString());
//		}
//		
//		List<Factura> listaFacturaJF = this.facturaService.buscarPorFechaJOINFETCH(LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));
//	
//		for(Factura factura : listaFacturaJF) {
//			LOG.info(factura.toString());
//		}
//		
//		List<DetalleFactura> listaDetalles = this.detalleFacturaServi.buscarProductos(new BigDecimal(100.0), LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));
//	
//		for(DetalleFactura factura : listaDetalles) {
//			LOG.info(factura.toString());
//		}
//		
//		Cliente cliente = new Cliente();
//		cliente.setNombre("Nicolas");
//		
//		List<String> numeros = new ArrayList<String>();
//		numeros.add("096363564");
//		numeros.add("091234567");
//		
//		cliente.setTelefonos(numeros);
//		
//		List<FacturaSencilla> lista = this.facturaService.buscarPorFechaSencilla(LocalDateTime.of(1989,  Month.AUGUST, 8, 12, 45));
//		
//		for(FacturaSencilla factura : lista) {
//			LOG.info(factura.toString());
//		}
//		
//		
//		Turista t1 = new Turista();
//		t1.setNombre("Turista 1");
//		t1.setValor(new BigDecimal("30"));
//		t1.setAbono(new BigDecimal("10"));
//		
//		this.turistaService.guardarTurista(t1);
//		
//		Turista t2 = new Turista();
//		t2.setNombre("Turista 2");
//		t2.setValor(new BigDecimal("50"));
//		t2.setAbono(new BigDecimal("25"));
//		
//		this.turistaService.guardarTurista(t2);
//		
//		List<Turista> listaCalcualda = this.turistaService.obtenerTodosTuristas();
//		
//		for(Turista turista : listaCalcualda) {
//			LOG.info(turista.toString());
//			LOG.info("SALDO: " + turista.getSaldo());
//		}
		
		CuentaBancaria cb1 = new CuentaBancaria();
		cb1.setNumero("1234");
		cb1.setClienteCedula("1712345678");
		cb1.setSaldo(new BigDecimal("100"));
		cb1.setTipo("Ahorros");
		
		this.cuentaBancariaServi.insertarCuentaBancaria(cb1);
		
		CuentaBancaria cb2 = new CuentaBancaria();
		cb2.setNumero("5678");
		cb2.setClienteCedula("1709876543");
		cb2.setSaldo(new BigDecimal("500"));
		cb2.setTipo("Ahorros");

		this.cuentaBancariaServi.insertarCuentaBancaria(cb2);
		
	}

}
