package rnd.expression.parser.tree.node;

public class DNode<T> extends XNode {

	public static enum DNodeType {
		LITERAL, VARIABLE
	};

	private final T data;
	private final DNodeType nodeType;

	public DNode(T data, DNodeType nodeType) {
		this.data = data;
		this.nodeType = nodeType;
	}

	public T getData() {
		return data;
	}
	
	public DNodeType getNodeType() {
		return nodeType;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
