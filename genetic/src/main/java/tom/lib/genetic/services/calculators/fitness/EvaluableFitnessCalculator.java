package tom.lib.genetic.services.calculators.fitness;

import tom.lib.genetic.interfaces.Evaluable;
import tom.lib.genetic.interfaces.FitnessCalculator;

/**
 * 
 * @author styfo
 *
 * @param <T> must implements Evaluable
 */
public class EvaluableFitnessCalculator<T> implements FitnessCalculator<T> {

	@Override
	public double calculateFitness(T selectionnable) {
		return ((Evaluable) selectionnable).getFitness();
	}
	
}
