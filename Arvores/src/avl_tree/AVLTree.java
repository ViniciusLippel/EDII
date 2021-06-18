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
	/*public void delete(int num) {
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
	}*/
	
	//Delete
	public void delete(int num) {
		this.root = deleteNode(this.root, num);
	}
	
	//Delete node
	public Node deleteNode(Node node, int num) {

        if (node == null)
            return node;
        
        if (num < node.getNum())
            node.setLeft(deleteNode(node.getLeft(), num));
        
        else if (num > node.getNum())
            node.setRight(deleteNode(node.getRight(), num));
 
        else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null)
                return node.getLeft();
            node.setNum(successor(node.getRight()));
            node.setRight(deleteNode(node.getRight(), node.getNum()));
        }
 
        return node;
	}
	
	//Find successor in order
	int successor(Node node) {
		
        int suc = node.getNum();
        
        while (node.getLeft() != null)
        {
            suc = node.getLeft().getNum();
            node = node.getLeft();
        }
        return suc;
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
	
	
	//Verify tree balance
	public boolean verifyBalance(Node node) {
		
		if (node == null)
			return true;
		
		int lh = height(node.getRight());
		int rh = height(node.getLeft());
		
		if (Math.abs(lh - rh) <= 1 && verifyBalance(node.getLeft()) && verifyBalance(node.getRight()))
			return true;
		
		return false;
	}
	
	//Branch height
	public int height(Node node) {
		
        if (node == null)
            return 0;
 
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}
	
	//Verify if other tree is identical
	public boolean isIdentical(AVLTree avl) {
		return compare(avl.getRoot(), this.root);
	}
	
	//Compare two trees from root
	public boolean compare(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		else 
	    { 
	        if (node1.getNum() == node2.getNum() && 
	            compare(node1.getLeft(), node2.getLeft()) && 
	            compare(node1.getRight(), node2.getRight()))
	            return true;
	    }
		
		return false;
	}
	
	//Rotate left
	public void rotateLeft() {
		
	}
	
	//Rotate right
	public void rotateRight() {
		
	}
	
}
