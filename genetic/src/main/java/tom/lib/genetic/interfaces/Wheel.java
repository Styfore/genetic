package tom.lib.genetic.interfaces;

import java.util.Map;
import java.util.TreeMap;

public interface Wheel<T> {
	public TreeMap<Double, T> calculateProbabilities(Map<T, Double> elToFitness);
}
