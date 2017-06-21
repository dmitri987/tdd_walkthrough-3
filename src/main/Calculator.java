package main;

import java.math.BigDecimal;
import java.util.HashMap;
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
    	operations = new HashMap<>();
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
        Operation operation = operations.get(op);        
        operation.apply(values);        
    }

	public void registerOperation(String symbol, Operation operation) {
		operations.put(symbol, operation);		
	}
}
