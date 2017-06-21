package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import main.BinaryOperation;
import main.Calculator;
import main.Operation;

/**
 * Created by matthewtodd on 30/03/2016.
 */
public class OperationsTest {
    private Calculator calculator;
    private static final BigDecimal value2 = new BigDecimal(20);
    private static final BigDecimal value1 = new BigDecimal(1);

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
        assertEquals(value2.add(value1), calculator.getAccumulator());
    }

    @Test
    public void testSubtractExecution() {
        calculator.execute("-");
        assertEquals(value2.subtract(value1), calculator.getAccumulator());
    }
    
    @Test
    public void testMultiplication(){
    	calculator.execute("*");
    	assertEquals(value2.multiply(value1), calculator.getAccumulator());
    }
    
    @Test
    public void testDivision(){
    	calculator.execute("/");
    	assertEquals(value2.divide(value1), calculator.getAccumulator());
    }
    
    @Test
    public void testPowerWithTwoOperands(){
    	calculator.execute("^");
    	assertEquals(value2.pow(value1.intValue()), calculator.getAccumulator());
    }
    
    @Test
    public void testRegisterPercentOperation(){
    	
    	Operation operation = new BinaryOperation(){
			@Override
			protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {				
				return value2.multiply(value1).divide(BigDecimal.valueOf(100));
			}    		
    	};
    	
    	calculator.registerOperation("%", operation);
    	calculator.execute("%");
    	assertEquals(value2.multiply(value1).divide(BigDecimal.valueOf(100)), calculator.getAccumulator());    	
    }
    
    @Test 
    public void testUnregisteredOperation(){
    	try{
    		calculator.execute("ddd");
    		fail("Execution of unregistered operation should fail");
    	}
    	catch (Exception e){    		
    	}
    	
    }
    
    
    
}
