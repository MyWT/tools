package rnd.expression.operator;

import static rnd.expression.operator.Operator.OperatorAssociativity.Left;

public class RelationalOperators extends AbstractOperator {

	public static final RelationalOperators LT = new RelationalOperators("<", Left, 4);
	public static final RelationalOperators GT = new RelationalOperators(">", Left, 4);
	public static final RelationalOperators LTE = new RelationalOperators("<=", Left, 4);
	public static final RelationalOperators GTE = new RelationalOperators(">=", Left, 4);

	RelationalOperators(String opCode, OperatorAssociativity associativity, int precedence) {
		super(opCode, associativity, precedence);
	}

}