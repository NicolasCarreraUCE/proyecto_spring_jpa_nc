package ec.edu.uce.interfaces.funcionales;

public class MainMetodosReferenciados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. Implementar por clases
		IPersonaSupplier<String> persona = new PersonaSupplierImpl();
		String mensaje = persona.get();
		System.out.println(mensaje);
		
		// 2. Implementar por Lambdas
		IPersonaSupplier<String> persona1 = () -> "Implementacion por LAMBDA";
		String mensaje1 = persona1.get();
		System.out.println(mensaje1);
		
		// 3. Métodos referenciados
		PersonaSupplierImpl personaImpl = new PersonaSupplierImpl();
		IPersonaSupplier<String> persona2 = personaImpl::get;
		String mensaje2 = persona2.get();
		System.out.println(mensaje2);
		
		// 3.1
		PersonaSupplierSinImpl personaSinImpl = new PersonaSupplierSinImpl();
		IPersonaSupplier<String> persona3 = personaSinImpl::get2;
		String mensaje3 = persona3.get();
		System.out.println(mensaje3);
		
		IPersonaSupplier<Integer> persona4 = personaSinImpl::get3;
		Integer mensaje4 = persona4.get();
		System.out.println(mensaje4);
		
		// 3.2
		PersonaPredicateImpl personaPredi = new PersonaPredicateImpl();
		IPersonaPredicate<String> personaPredi2 = personaPredi::evaluar;
		boolean nombre = personaPredi2.evaluar("Mensaje");
	}

}
