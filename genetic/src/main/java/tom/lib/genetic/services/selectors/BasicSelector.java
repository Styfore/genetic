package tom.lib.genetic.services.selectors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import tom.lib.genetic.interfaces.Copier;
import tom.lib.genetic.interfaces.FitnessCalculator;
import tom.lib.genetic.interfaces.Selector;
import tom.lib.genetic.interfaces.Wheel;
import tom.lib.genetic.services.calculators.fitness.EvaluableFitnessCalculator;
import tom.lib.genetic.services.calculators.wheels.ProportionateWheel;
import tom.lib.genetic.services.suppliers.BasicSupplier;

public class BasicSelector<T> implements Selector<T>, InitializingBean {

	private Wheel<T> wheel;
	private FitnessCalculator<T> fitnessCalculator;
	private Copier<T> copier;

	@Override
	public List<T> select(List<T> population, double conservationRate) {
		// get fitnesses of all population
		Map<T, Double> elToFitness = new HashMap<>();
		population.stream().forEach(p -> elToFitness.put(p, fitnessCalculator.calculateFitness(p)));
		
		// Calculate probabilities of each element to be selected
		TreeMap<Double, T> probas = wheel.calculateProbabilities(elToFitness);
		BasicSupplier<T> basicSupplier = new BasicSupplier<>(copier, probas);
		
		int nbKeeped = (int) (conservationRate*population.size());
		List<T> newPopulation = basicSupplier.makeList(population.size() - nbKeeped);
		
		newPopulation.addAll(probas.values().stream().skip(population.size() - nbKeeped).collect(Collectors.toList()));

		return newPopulation;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(copier, "a Copier must be set");
		if (wheel == null){
			wheel = new ProportionateWheel<>();
		}		
		if (fitnessCalculator == null){
			fitnessCalculator = new EvaluableFitnessCalculator<>();
		}
	}
	
	public void setWheel(Wheel<T> wheel) {
		this.wheel = wheel;
	}

	public void setFitnessCalculator(FitnessCalculator<T> fitnessCalculator) {
		this.fitnessCalculator = fitnessCalculator;
	}
	
	public void setCopier(Copier<T> copier) {
		this.copier = copier;
	}
}
