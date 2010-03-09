package rnd.expression.parser.tree.node;

public class RNode extends XNode {

	private XNode xNode;

	public void setXNode(XNode xNode) {
		this.xNode = xNode;
		this.xNode.setParentNode(this);
	}

	public XNode getXNode() {
		return xNode;
	}

}
