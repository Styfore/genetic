package tom.lib.genetic.services.suppliers;

import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import tom.lib.genetic.interfaces.Copier;
import tom.lib.genetic.interfaces.PopulationSupplier;

public class BasicSupplier<T> implements PopulationSupplier<T>	 {

	private Copier<T> copier;
	private TreeMap<Double, T> probas;
	private Random random;
	
	public BasicSupplier(Copier<T> copier, TreeMap<Double, T> probas) {
		this.probas = probas;
		this.random = new Random();
	}
	
	
	@Override
	public T get() {
		double r = random.nextDouble();
		Entry<Double, T> entryToCopy = probas.ceilingEntry(r);
		System.out.println(r + " -> " +probas.ceilingEntry(r));
		if (entryToCopy == null){
			entryToCopy = probas.lastEntry();
		}
		return copier.copy(entryToCopy.getValue());
	}

}
