package ec.edu.uce.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaFunction<T,R> {
	public R apply(T arg1);
}
