import java.math.BigDecimal;

/**
 * Created by matthewtodd on 30/03/2016.
 */
public abstract class BinaryOperation  implements Operation {
    @Override
    public void apply(OperandStack values) {
        BigDecimal value1 = values.peek();
        values.pop();
        BigDecimal value2 = values.peek();
        values.replaceTop(calculate(value1, value2));
    }

    protected abstract BigDecimal calculate(BigDecimal value1, BigDecimal value2);
}
