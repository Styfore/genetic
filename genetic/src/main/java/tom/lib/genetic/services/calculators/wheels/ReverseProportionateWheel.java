package tom.lib.genetic.services.calculators.wheels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tom.lib.genetic.interfaces.Wheel;

public class ReverseProportionateWheel<T> implements Wheel<T> {

	
	@Override
	public TreeMap<Double, T> calculateProbabilities(Map<T, Double> elToFitness) {
		TreeMap<Double, T> treemap = new TreeMap<>();
		
		if (elToFitness.size() > 1){
			double reversedFitnessSum = elToFitness.values().parallelStream().mapToDouble(i -> 1./(i.doubleValue() + 1.)).sum();
			List<T> population = new ArrayList<>();
			population.addAll(elToFitness.keySet());
			population.sort(getComparator(elToFitness));
			
			double lastProba = (1./(elToFitness.get(population.get(0))+1.))/reversedFitnessSum;
			treemap.put(lastProba, population.get(0));
			for (int j = 1; j < population.size(); j++) {
				lastProba = lastProba + (1./(elToFitness.get(population.get(j))+1.))/reversedFitnessSum;
				treemap.put(lastProba, population.get(j));	
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
				return -1*Double.compare(fitnesses.get(o1), fitnesses.get(o2));
			}
		};
	}
	
}
