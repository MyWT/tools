package rnd.expression.operator;

public interface Operator {

	public static enum OperatorAssociativity {
		Left, Right
	}

	String getOpCode();

	OperatorAssociativity getAssociativity();

	int getPrecedence();

}