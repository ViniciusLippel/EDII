package avl_tree;

public class AVLTree {

	private Node root;
	
	//Getters & Setters
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	
	//Insert value
	public void insert(int num) {
		if(this.root == null)
			this.root = new Node(num);
		else
			addNode(root, num);
	}
	
	//Delete value
	public void delete(int num) {
		
	}
		
	//Add Node
	public void addNode(Node node, int num) {
		if (num > node.getNum()) {
			if(node.getRight() != null)
				addNode(node.getRight(), num);
			else 
				node.setRight(new Node(num));
		}
		else if(num < node.getNum()) {
			if(node.getLeft() != null)
				addNode(node.getLeft(), num);
			else
				node.setLeft(new Node(num));
		}
	}
	
	//Find Node
	public Node findNode(Node node, int num) {
		
		if (num > node.getNum()) {
			if(node.getRight() != null)
				addNode(node.getRight(), num);
		}
		else if(num < node.getNum()) {
			if(node.getLeft() != null)
				addNode(node.getLeft(), num);
		}
		else if(num == node.getNum())
			return node;
		
		return null;
	}
}
