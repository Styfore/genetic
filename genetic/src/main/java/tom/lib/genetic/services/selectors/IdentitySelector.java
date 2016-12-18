package tom.lib.genetic.services.selectors;

import java.util.List;

import tom.lib.genetic.interfaces.Selector;

public class IdentitySelector<T> implements Selector<T> {

	@Override
	public List<T> select(List<T> population, double conservationRate) {
		return population;
	}
}
