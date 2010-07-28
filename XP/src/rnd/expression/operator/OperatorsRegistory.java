package rnd.expression.operator;

import java.util.HashMap;
import java.util.Map;


public class OperatorsRegistory<O extends Operator> {

	private Map<String, O> operatorMap = new HashMap<String, O>();
	private Map<String, O> operatorMap2 = new HashMap<String, O>();

	public void registerOperator(O operator) {
		operatorMap.put(operator.getOpCode(), operator);
	}

	public void registerOperator2(O operator) {
		operatorMap2.put(operator.getOpCode(), operator);
	}

	public Operator getOperator(char ch) {
		return operatorMap.get(new String(new char[] { ch }));
	}

	public Operator getOperator2(char... ch) {
		return operatorMap2.get(new String(ch));
	}

}
