package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import main.Calculator;

public class UnaryOperationTest {
	static private final BigDecimal value = new BigDecimal(5);
	
	private Calculator calculator;
	
	
	
	@Before
	public void createCalculatorWithOneValue(){
		calculator = new Calculator();
		calculator.setAccumulator(value);		
	}
	
	@Test
	public void testAccumulatorAfterSet(){
		assertEquals(value, calculator.getAccumulator());
	}
	
	@Test
	public void testAccumulatorAfterEnter(){
		calculator.enter();
		assertEquals(BigDecimal.ZERO, calculator.getAccumulator());
		calculator.drop();
		assertEquals(value, calculator.getAccumulator());
	}
	
	@Test
	public void testPowerWithOneOperandInAccumulator(){
		calculator.execute("^");
		assertEquals(value.pow(2), calculator.getAccumulator());
	}
	
	

}
