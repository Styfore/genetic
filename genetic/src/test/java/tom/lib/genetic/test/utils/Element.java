package tom.lib.genetic.test.utils;

import tom.lib.genetic.interfaces.Evaluable;

public class Element implements Evaluable {

	private int id;
	private double fitness;
	
	public Element(int id) {
		this.id =  id;
		this.fitness = (double) id;
	}
	
	@Override
	public double getFitness() {
		return fitness;
	}

	@Override
	public String toString() {
		return "E"+getId();
	}
	
	public int getId() {
		return id;
	}
}
