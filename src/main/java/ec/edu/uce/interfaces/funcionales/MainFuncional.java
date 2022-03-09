package ec.edu.uce.interfaces.funcionales;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import ec.edu.uce.modelo.Paciente;

public class MainFuncional {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersonaSupplier<String> supplier = new PersonaSupplier();
		System.out.println(supplier.get());
		
		IPersonaSupplier<String> supplier1 = () -> {return "HOLA MUNDO CON LLAVES";};
		System.out.println(supplier1.get());
		
		IPersonaSupplier<String> supplier2 = () -> "HOLA MUNDO";
		System.out.println(supplier2.get());
		
		ConsumoInterfacesFuncionales consumo = new ConsumoInterfacesFuncionales();
		String resultado = consumo.consumirSupplier(() -> "HOLA MUNDO!!");
		System.out.println(resultado);
		
		// SUPPLIER EN JAVA	
		Stream<String> test = Stream.generate(() -> "HOLA").limit(100);
		
//		test.forEach(x -> System.out.println(x + "PRUEBA"));
		
		// CONSUMER
		IPersonaConsumer<Integer> personaConsumer = number -> System.out.println(number);
		personaConsumer.accept(7);
		
		IPersonaConsumer<Integer> personaConsumer1 = number -> System.out.println(number.intValue() + 1);
		personaConsumer.accept(7);
		
		consumo.consumirConsumer(number -> System.out.println(number + 10), 2);
		
		// CONSUMER JAVA
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6);
		listaNumeros.forEach(number -> System.out.println(number));
		
		// PREDICATE
		System.out.println("PREDICATE");
		boolean resultado2 = consumo.consumirPredicate(cadena -> cadena.contains("E"), "Edision");
		System.out.println(resultado2);
		
		// PREDICATE JAVA
		Stream<Integer> numeroFiltrados = listaNumeros.stream().filter(num1 -> num1 > 4);
		numeroFiltrados.forEach(num -> System.out.println(num));
		
		// FUNCTION
		System.out.println("FUNCTION");
		Integer nuevoValor = consumo.consumirFuntion(cadena -> Integer.parseInt(cadena) + 7, "2");
		System.out.println(nuevoValor);
		
		// FUNCTTION JAVA
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> numeroLista.toString() + "N");
		listaCambiada.forEach(cadena -> System.out.println(cadena));
		
		// LISTA NUMEROS
//		listaNumeros.stream().reduce(null);
	}

}
