package tom.lib.genetic.test.wheels;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import tom.lib.genetic.services.calculators.wheels.ProportionateWheel;
import tom.lib.genetic.test.utils.Element;
import tom.lib.genetic.test.utils.ElementGenerator;

public class ProportionateWheelTest {

	
	
	@Test
	public void test(){
		ProportionateWheel<Element> wheel = new ProportionateWheel<>();
		Map<Element, Double> elements = ElementGenerator.generateMap(5);
		TreeMap<Double, Element> result = wheel.calculateProbabilities(elements);
		Iterator<Element> itE = result.values().iterator();
		Assert.assertEquals(10, itE.next().getId());
		Assert.assertEquals(20, itE.next().getId());
		Assert.assertEquals(30, itE.next().getId());
		Assert.assertEquals(40, itE.next().getId());
		Assert.assertEquals(50, itE.next().getId());

		Iterator<Double> it = result.keySet().iterator();
		Assert.assertEquals(0.06666666666666667, it.next(), 0.0001);
		Assert.assertEquals(0.2, it.next(), 0.0001);
		Assert.assertEquals(0.4, it.next(), 0.0001);
		Assert.assertEquals(0.66666666666666667, it.next(), 0.0001);
		Assert.assertEquals(1.0, it.next(), 0.0001);
	}
	
}
