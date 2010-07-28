package rnd.expression.parser.tree.node;

public class DNode<T> extends XNode {

	private T data;

	public DNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}

}
