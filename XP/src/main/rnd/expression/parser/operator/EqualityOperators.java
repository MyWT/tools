package rnd.expression.parser.operator;

import static rnd.expression.parser.operator.Operator.OperatorAssociativity.Left;

public class EqualityOperators extends AbstractOperator {

	// 3
	public static final EqualityOperators EQUAL_TO = new EqualityOperators("==", Left, 3);
	public static final EqualityOperators NOT_EQUAL_TO = new EqualityOperators("==", Left, 3);

	EqualityOperators(String opCode, OperatorAssociativity associativity, int precedence) {
		super(opCode, associativity, precedence);
	}

}