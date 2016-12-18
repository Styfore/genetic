package tom.lib.genetic.test.wheels;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import tom.lib.genetic.services.calculators.wheels.ReverseProportionateWheel;
import tom.lib.genetic.test.utils.Element;
import tom.lib.genetic.test.utils.ElementGenerator;

public class ReverseProportionateWheelTest {

	@Test
	public void test(){
		ReverseProportionateWheel<Element> wheel = new ReverseProportionateWheel<>();

		Map<Element, Double> elements = ElementGenerator.generateMap(5);
		TreeMap<Double, Element> result = wheel.calculateProbabilities(elements);
		
		Iterator<Element> itE = result.values().iterator();
		Assert.assertEquals(50, itE.next().getId());
		Assert.assertEquals(40, itE.next().getId());
		Assert.assertEquals(30, itE.next().getId());
		Assert.assertEquals(20, itE.next().getId());
		Assert.assertEquals(10, itE.next().getId());

		Iterator<Double> it = result.keySet().iterator();
		Assert.assertEquals(0.09129, it.next(), 0.0001);
		Assert.assertEquals(0.20484, it.next(), 0.0001);
		Assert.assertEquals(0.35503, it.next(), 0.0001);
		Assert.assertEquals(0.57674, it.next(), 0.0001);
		Assert.assertEquals(1.0, it.next(), 0.0001);
		
	}
	
	@Test
	public void testWithZero(){
		ReverseProportionateWheel<Element> wheel = new ReverseProportionateWheel<>();

		Map<Element, Double> elements = ElementGenerator.generateMap(0, 5);
		TreeMap<Double, Element> result = wheel.calculateProbabilities(elements);
		
		Iterator<Element> itE = result.values().iterator();
		Assert.assertEquals(40, itE.next().getId());
		Assert.assertEquals(30, itE.next().getId());
		Assert.assertEquals(20, itE.next().getId());
		Assert.assertEquals(10, itE.next().getId());
		Assert.assertEquals(0, itE.next().getId());

		Iterator<Double> it = result.keySet().iterator();
		Assert.assertEquals(0.02040, it.next(), 0.0001);
		Assert.assertEquals(0.04739, it.next(), 0.0001);
		Assert.assertEquals(0.08724, it.next(), 0.0001);
		Assert.assertEquals(0.16330, it.next(), 0.0001);
		Assert.assertEquals(1.0, it.next(), 0.0001);
		
	}
}
