package main;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by matthewtodd on 26/01/2016.
 */
public class Calculator {

    private OperandStack values = new OperandStack();
    
    private Map<String, Operation> operations = null;
    
    public Calculator(){
    	initOperations();
    }
    
    private void initOperations(){
    	operations.put("+", new AddOperation());
    	operations.put("-", new SubtractOperation());
    	operations.put("*", new MultiplicationOperation());
    	operations.put("/", new DivisionOperation());
    	operations.put("^", new PowerOperation());    	
    }

    public BigDecimal getAccumulator() {
        return values.peek();
    }

    public void setAccumulator(BigDecimal value) {
        values.replaceTop(value);
    }
    
    public void setAccumulator(long value){
    	setAccumulator(new BigDecimal(value));
    }

    public void enter() {
        values.push(getAccumulator());
        setAccumulator(0);
    }

    public void drop() {
        values.pop();
    }

    public void execute(String op) {
        Operation operation = null;
        if ("+".equals(op))
            operation = new AddOperation();
        else if ("-".equals(op))
            operation = new SubtractOperation();
        else if ("*".equals(op))
        	operation = new MultiplicationOperation();
        else if ("/".equals(op))
        	operation = new DivisionOperation();
        else if ("^".equals(op))
        	operation = new PowerOperation();
        
        operation.apply(values);
        
    }
}
