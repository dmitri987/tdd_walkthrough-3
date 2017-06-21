package main;

import java.math.BigDecimal;

/**
 * Created by matthewtodd on 30/03/2016.
 */
public class AddOperation extends BinaryOperation {

    @Override
    protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
        return value1.add(value2);
    }
}
