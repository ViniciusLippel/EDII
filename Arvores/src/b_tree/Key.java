package b_tree;

public class Key {
	
	private Node prevNode;
	private int num;
	
	
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Key [prevNode=");
		builder.append(prevNode);
		builder.append(", num=");
		builder.append(num);
		builder.append("]");
		return builder.toString();
	}
	
}
