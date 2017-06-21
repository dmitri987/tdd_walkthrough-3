package main;

import java.math.BigDecimal;

public class PowerOperation extends BinaryOperation {

	@Override
	protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {		
		BigDecimal result = value2.equals(BigDecimal.ZERO)  ? value1.pow(2) : value2.pow(value1.intValue()); 
		return result;
	}

}
