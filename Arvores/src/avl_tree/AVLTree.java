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
	
	//Compare two trees
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
	
	//String of nodes by each level
	public String nodesByLevel() {
		StringBuilder b = new StringBuilder();
		if (this.root != null) {
			b.append("Root: "+this.root.getNum());
			int j = 1;
			String s = nodesInLevel(this.root, 0, j);
			while (s != "") {
				b.append("\nLvl "+j+": "+s);
				j++;
				s = nodesInLevel(this.root, 0, j);
			}
		}
		return b.toString();
	}
	
	//String of nodes in specific level
	public String nodesInLevel(Node node, int cLvl, int oLvl) {
		if (node != null){
			if(cLvl < oLvl-1) {
				return nodesInLevel(node.getLeft(), cLvl+1, oLvl)+nodesInLevel(node.getRight(), cLvl+1, oLvl);
			}
			else{
				StringBuilder b = new StringBuilder();
				if (node.getLeft() != null) {
					b.append(node.getLeft().getNum());
					b.append(" ");
				}
				if (node.getRight() != null) {
					b.append(node.getRight().getNum());
					b.append(" ");
				}
				return b.toString();
			}
		}
		return "";
	}
	
	//Rotate left
	public void rotateLeft() {
		
	}
	
	//Rotate right
	public void rotateRight() {
		
	}
	
}
