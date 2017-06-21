package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.Calculator;

/**
 * Created by matthewtodd on 30/03/2016.
 */
public class OperationsTest {
    private Calculator calculator;
    private static final BigDecimal value2 = new BigDecimal(20);
    private static final BigDecimal value1 = new BigDecimal(4);

    @Before
    public void createCalculatorWithTwoValues() {
        calculator = new Calculator();
        calculator.setAccumulator(value2);
        calculator.enter();
        calculator.setAccumulator(value1);
    }

    @Test
    public void testAddExecution() {
        calculator.execute("+");
        assertEquals(new BigDecimal(24), calculator.getAccumulator());
    }

    @Test
    public void testSubtractExecution() {
        calculator.execute("-");
        assertEquals(new BigDecimal(16), calculator.getAccumulator());
    }
    
    @Test
    public void testMultiplication(){
    	calculator.execute("*");
    	assertEquals(new BigDecimal(80), calculator.getAccumulator());
    }
    
    @Test
    public void testDivision(){
    	calculator.execute("/");
    	assertEquals(new BigDecimal(5), calculator.getAccumulator());
    }
    
    @Test
    public void testPowerWithTwoOperands(){
    	calculator.execute("^");
    	assertEquals(value2.pow(value1.intValue()), calculator.getAccumulator());
    }
    
    
    
}
