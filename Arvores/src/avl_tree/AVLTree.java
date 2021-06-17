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
	/*public void delete(int num) {
		Node aux = findNode(this.root, num);
		Node auxR = aux.getRight();
		Node.auxL = aux.getLeft();
	}*/
		
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
	
	//Delete Node
	public void delete(int num) {
		Node found = findNode(this.root, num);
		System.out.println("Deletar nodo "+found.getNum());
		if (found != null) {
			if ((found.getRight() != null) && (found.getLeft() != null)) {
				Node suc = findSuccessor(found);
				if (suc == found.getRight()) {
					found.setNum(suc.getNum());
					found.setRight(suc.getRight());
				}
				else {
					found.setNum(suc.getNum());
				}
			}
			else if ((found.getRight() != null) && (found.getLeft() == null)) {
				found.setNum(found.getRight().getNum());
				found.setRight(found.getRight().getRight());
				found.setLeft(found.getRight().getLeft());
			}
			else if ((found.getRight() == null) && (found.getLeft() != null)) {
				found.setNum(found.getLeft().getNum());
				found.setRight(found.getLeft().getRight());
				found.setLeft(found.getLeft().getLeft());
			}
			else if((found.getRight() == null) && (found.getLeft() == null)) {
				found = null;
			}
		}
	}
	
	//Find Node
	public Node findNode(Node node, int num) {
		
		if (num > node.getNum()) {
			if(node.getRight() != null)
				return findNode(node.getRight(), num);
		}
		else if(num < node.getNum()) {
			if(node.getLeft() != null)
				return findNode(node.getLeft(), num);
		}
		else if(num == node.getNum())
			return node;
		
		return null;
	}
	
	//Find successor node in order
	public Node findSuccessor(Node node) {
		return findLeftmost(node.getRight());
	}
	
	//Find parent node
	public Node findParent(Node node) {
		
		return null;
	}
	
	//Find leftmost node
	public Node findLeftmost(Node node) {
		if (node.getLeft() != null)
			return findLeftmost(node.getLeft());
		else
			return node;
	}
	
	//Verify tree balance
	public boolean verifyBalance(Node node) {
		
	}
	
	//Branch height
	public int branchHeight(Node node) {
		
        if (node == null)
            return 0;
 
        return 1 + Math.max(branchHeight(node.getLeft()), branchHeight(node.getRight()));
	}
	
	//Rotate left
	public void rotateLeft() {
		
	}
	
	//Rotate right
	public void rotateRight() {
		
	}
	
}
