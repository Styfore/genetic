package tom.lib.genetic.interfaces;

public interface FitnessCalculator<T> {
	public double calculateFitness(T selectionnable);
}
