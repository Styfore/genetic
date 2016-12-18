package tom.lib.genetic.interfaces;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface PopulationSupplier<T> extends Supplier<T>  {

	public default Stream<T> makeStream(){
		return Stream.generate(this);
	}
	
	public default Stream<T> makeStream(int numSelect){
		return Stream.generate(this).limit(numSelect);
	}
	
	public default List<T> makeList(int numSelect){
		return Stream.generate(this).limit(numSelect).collect(Collectors.toList());
	}
}
