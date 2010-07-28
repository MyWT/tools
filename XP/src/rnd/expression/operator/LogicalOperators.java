package rnd.expression.operator;

import static rnd.expression.operator.Operator.OperatorAssociativity.Left;
import static rnd.expression.operator.Operator.OperatorAssociativity.Right;

public class LogicalOperators extends AbstractOperator {

	// 1
	public static final LogicalOperators OR = new LogicalOperators("||", Left, 1);

	// 2
	public static final LogicalOperators AND = new LogicalOperators("&&", Left, 2);

	// 5
	public static final LogicalOperators NOT = new LogicalOperators("!", Right, 7);

	LogicalOperators(String opCode, OperatorAssociativity associativity, int precedence) {
		super(opCode, associativity, precedence);
	}

}