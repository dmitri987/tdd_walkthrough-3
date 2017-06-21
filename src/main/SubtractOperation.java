import java.math.BigDecimal;

/**
 * Created by matthewtodd on 30/03/2016.
 */
public class SubtractOperation extends BinaryOperation {

    @Override
    protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
        return value2.subtract(value1);
    }
}
