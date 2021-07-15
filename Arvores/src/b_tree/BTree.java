package b_tree;

import java.util.ArrayList;

public class BTree {
	
	private int order;
	private Node root;
	
	//Constructor
	public BTree(int order) {
		this.order = order;
	}
	
	//Getters & Setters
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
	
	
	//Insert
	public void insert(int num) {
		if (this.root != null) {
			addInNode(findNode(this.root, num), num);
		}
		else {
			this.root = new Node();
			root.addKey(num);
		}
	}
	
	//FindNode
	public Node findNode(Node node, int num) {
		if (node.getLastNode()!=null) {
			for(int i=0; i<node.getNumKeys(); i++) {
				if(num < node.getKeys().get(i).getNum()) 
					return findNode(node.getKeys().get(i).getPrevNode(), num);
			}
			return findNode(node.getLastNode(), num);
		}
		else {
			return node;
		}
	}
	
	public Node findPredNode(Node node, Node nodeToFind) {
		int num = nodeToFind.getKeys().get(0).getNum();
		if (node.getLastNode()!=null) {
			for(int i=0; i<node.getNumKeys(); i++) {
				if(num < node.getKeys().get(i).getNum()) {
					if (node.getKeys().get(i).getPrevNode() == nodeToFind)
						return node;
					else
						return findPredNode(node.getKeys().get(i).getPrevNode(), nodeToFind);
				}
			}
			if(node.getLastNode() == nodeToFind)
				return node;
			else
				return findPredNode(node.getLastNode(), nodeToFind);
		}
		else {
			return null;
		}
	}
	
	//AddInNode
	public void addInNode(Node node, int num) {
		node.addKey(num);
		if(node.getNumKeys()>order-1) {
			this.root = this.split(node);
			//Node aux = this.split(node);
			//Node auxRight = aux.getLastNode();
		}
	}
	
	//Split
	public Node split(Node node) {
		Node right = new Node();
		Node left = new Node();
			
		left.setKeys(new ArrayList<Key>(node.getKeys().subList(0, order/2)));
		right.setKeys(new ArrayList<Key>(node.getKeys().subList(order/2, order)));

		int aux = right.getKeys().get(0).getNum();
		Node promote = new Node();
		promote.addKey(aux);
		promote.getKeys().get(0).setPrevNode(left);
		promote.setLastNode(right);
		
		right.getKeys().remove(0);
		left.setNumKeys(left.getKeys().size());
		right.setNumKeys(right.getKeys().size());
		
		return promote;
	}
	
	
	
	
	//To String/
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
