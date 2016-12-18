package tom.lib.genetic.services.mutators;

import tom.lib.genetic.interfaces.Mutator;

public class IdentityMutator<T> implements Mutator<T>{

	@Override
	public T mute(T element) {
		return element;
	}

}
