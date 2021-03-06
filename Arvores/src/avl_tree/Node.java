package avl_tree;

public class Node {
	
	private int num;
	private Node right;
	private Node left;
	
	public Node(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [num=");
		builder.append(num);
		builder.append(", right=");
		builder.append(right);
		builder.append(", left=");
		builder.append(left);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
