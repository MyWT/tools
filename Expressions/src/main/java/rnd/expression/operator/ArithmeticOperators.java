package rnd.expression.operator;

import static rnd.expression.operator.Operator.OperatorAssociativity.Left;

public class ArithmeticOperators extends AbstractOperator {

	// 1
	public static final ArithmeticOperators PLUS = new ArithmeticOperators("+", Left, 5);
	public static final ArithmeticOperators MINUS = new ArithmeticOperators("+", Left, 5);

	// 2
	public static final ArithmeticOperators MULTIPLY = new ArithmeticOperators("+", Left, 6);
	public static final ArithmeticOperators DIVIDE = new ArithmeticOperators("+", Left, 6);
	public static final ArithmeticOperators MODULO = new ArithmeticOperators("+", Left, 6);

	ArithmeticOperators(String opCode, OperatorAssociativity associativity, int precedence) {
		super(opCode, associativity, precedence);
	}

}