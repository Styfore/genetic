package tom.lib.genetic.interfaces;

import java.util.List;

public interface Crosser<T> {

	public List<T> crossover(List<T> parents);
}
