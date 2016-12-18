package tom.lib.genetic.test.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElementGenerator {
	
	public static List<Element> generate(int debut, final int n){
		List<Element> elements = IntStream.iterate(debut, (d) ->  d + 10).limit(n).mapToObj(d -> new Element(d)).collect(Collectors.toList());
		Collections.shuffle(elements);
		return elements;
	}
	
	public static List<Element> generate(final int n){
		List<Element> elements = IntStream.iterate(10, (d) ->  d + 10).limit(n).mapToObj(d -> new Element(d)).collect(Collectors.toList());
		Collections.shuffle(elements);
		return elements;
	}
	
	public static Map<Element, Double> generateMap(int debut, final int n){
		Map<Element, Double> elements = new HashMap<>();
		generate(debut, n).forEach(e -> elements.put(e, e.getFitness()));

		return elements;
	}
	
	public static Map<Element, Double> generateMap(final int n){
		Map<Element, Double> elements = new HashMap<>();
		generate(n).forEach(e -> elements.put(e, e.getFitness()));

		return elements;
	}
}
