package b_tree;

public class BTree {
	
	private int order;
	private Node root;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BTree [order=");
		builder.append(order);
		builder.append(", root=");
		builder.append(root);
		builder.append("]");
		return builder.toString();
	}
	
}
