package tom.lib.genetic.interfaces;

import java.util.List;

public interface Selector<T>  {
	public List<T> select(List<T> population, double conservationRate);
}
