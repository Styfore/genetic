package tom.lib.genetic.test.utils;

import tom.lib.genetic.interfaces.Copier;

public class ElementCopier implements Copier<Element> {

	@Override
	public Element copy(Element element) {
		return new Element(element.getId());
	}

}
