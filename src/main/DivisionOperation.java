package main;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class DivisionOperation extends BinaryOperation {

	@Override
	protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {		
		return value2.divide(value1);
	}

	
}
