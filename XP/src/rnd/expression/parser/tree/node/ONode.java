package rnd.expression.parser.tree.node;

import rnd.expression.operator.Operator;

public class ONode extends XNode {

	private Operator operator;

	public ONode(Operator operator) {
		this.operator = operator;
	}

	public Operator getOperator() {
		return operator;
	}

	@Override
	public String toString() {
		return operator.getOpCode();
	}

}