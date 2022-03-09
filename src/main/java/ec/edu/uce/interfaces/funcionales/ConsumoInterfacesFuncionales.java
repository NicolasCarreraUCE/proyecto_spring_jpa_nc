package ec.edu.uce.interfaces.funcionales;

public class ConsumoInterfacesFuncionales {

	public String consumirSupplier(IPersonaSupplier<String> suplier) {
		return suplier.get();
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(Integer.valueOf(valor));
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}
	
	public Integer consumirFuntion(IPersonaFunction<String, Integer> funcion, String cadena) {
		return funcion.apply(cadena);
	}
}
