package rnd.expression.parser.operator;

import java.util.HashMap;
import java.util.Map;

import rnd.expression.BinaryOperation;

public class OperatorsRegistory {

	private Map<String, Operator> operatorMap = new HashMap<String, Operator>();
	private Map<String, Operator> operatorMap2 = new HashMap<String, Operator>();
	private Map<String, BinaryOperation> operationMap = new HashMap<String, BinaryOperation>();

	public void registerOperator(Operator operator) {
		operatorMap.put(operator.getOpCode(), operator);
	}

	public void registerOperator(Operator operator, BinaryOperation bo) {
		registerOperator(operator);
		registerOperation(operator, bo);
	}

	public void registerOperator2(Operator operator) {
		operatorMap2.put(operator.getOpCode(), operator);
	}

	public void registerOperator2(Operator operator, BinaryOperation bo) {
		registerOperator2(operator);
		registerOperation(operator, bo);
	}

	public Operator getOperator(char ch) {
		return operatorMap.get(new String(new char[] { ch }));
	}

	public Operator getOperator2(char... ch) {
		return operatorMap2.get(new String(ch));
	}

	private void registerOperation(Operator operator, BinaryOperation bo) {
		operationMap.put(operator.getOpCode(), bo);
	}

	public BinaryOperation getBinaryOperation(Operator operator) {
		return operationMap.get(operator.getOpCode());
	}

}
