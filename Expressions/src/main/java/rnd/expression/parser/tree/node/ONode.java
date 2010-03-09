package rnd.expression.parser.tree.node;


public class ONode extends XNode {

	private String op;

	public ONode(String op) {
		this.op = op;
	}

	@Override
	public String toString() {
		return op.toString();
	}
}