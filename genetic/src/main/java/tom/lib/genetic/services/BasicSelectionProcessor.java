package tom.lib.genetic.services;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import tom.lib.genetic.interfaces.Copier;
import tom.lib.genetic.interfaces.Mutator;
import tom.lib.genetic.interfaces.SelectionItemProcessor;
import tom.lib.genetic.services.mutators.IdentityMutator;
import tom.lib.genetic.services.selectors.BasicSelector;

public class BasicSelectionProcessor<T> implements SelectionItemProcessor<T>, InitializingBean {

	private BasicSelector<T> basicSelector;
	private Mutator<T> mutator;
	private Copier<T> copier;
	private double conservationRate;

	@Override
	public void processGeneration(List<T> population) {
		// Selection
		List<T> selectedPopulation = basicSelector.select(population, conservationRate);

		// Mutation
		selectedPopulation.forEach(t -> mutator.mute(t));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(conservationRate, "conservationRate must be set");
		if (mutator == null) {
			mutator = new IdentityMutator<>();
		}
		if (basicSelector == null) {
			Assert.notNull(copier, "a Copier or a Selector must be set");
			basicSelector = new BasicSelector<>();
			basicSelector.setCopier(copier);
		}
	}

	public void setBasicSelector(BasicSelector<T> basicSelector) {
		this.basicSelector = basicSelector;
	}
	
	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
	}

	public void setCopier(Copier<T> copier) {
		this.copier = copier;
	}
}
