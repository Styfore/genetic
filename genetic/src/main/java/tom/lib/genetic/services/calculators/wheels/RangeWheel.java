package tom.lib.genetic.services.calculators.wheels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tom.lib.genetic.interfaces.Wheel;

public class RangeWheel<T> implements Wheel<T> {

	private boolean greaterIsBetter = true;
	
	@Override
	public TreeMap<Double, T> calculateProbabilities(Map<T, Double> elToFitness) {
		TreeMap<Double, T> treemap = new TreeMap<>();
		
		int size = elToFitness.size();
		if (size > 1){
			List<T> population = new ArrayList<>();
			population.addAll(elToFitness.keySet());
			population.sort(getComparator(elToFitness));
			
			double sum = size*(size + 1)/2;
			for (int i = 1; i <= size ; i++) {
				treemap.put(i*(i+1)/(2*sum), population.get(i-1));
			}
		}
		else{
			treemap.put(1., elToFitness.keySet().iterator().next());
		}
		return treemap;
	}
	
	

	private Comparator<T> getComparator(Map<T, Double> fitnesses){
		return new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				return (greaterIsBetter?1:-1)*Double.compare(fitnesses.get(o1), fitnesses.get(o2));
			}
		};
	}
	
	
	public void setGreaterIsBetter(boolean greaterIsBetter) {
		this.greaterIsBetter = greaterIsBetter;
	}
}
