package rnd.expression.parser.operator;


public class AbstractOperator implements Operator {

	private final String opCode;
	private OperatorAssociativity associativity;
	private int precedence;

	AbstractOperator(String opCode, OperatorAssociativity associativity, int precedence) {
		this.opCode = opCode;
		this.associativity = associativity;
		this.precedence = precedence;
	}

	public String getOpCode() {
		return opCode;
	}

	public OperatorAssociativity getAssociativity() {
		return associativity;
	}

	public int getPrecedence() {
		return precedence;
	}
	
	@Override
	public String toString() {
		return getOpCode();
	}

}
