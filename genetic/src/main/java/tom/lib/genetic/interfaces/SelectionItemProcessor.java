package tom.lib.genetic.interfaces;

import java.util.List;

public interface SelectionItemProcessor<T> {
	public void processGeneration(List<T> population);
}
