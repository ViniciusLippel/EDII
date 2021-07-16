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
	
	//INSERTING METHODS
	
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
	
	//AddInNode
	public void addInNode(Node node, int num) {
		node.addKey(num);
		if(node.getNumKeys()>order-1) {
			this.root = this.split(node);
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
	
	
	//SEARCHING METHODS
	
	
	//Recursive search
	public Key searchKey(Node node, int num) {
		for(int i=0; i<node.getNumKeys(); i++) {
			if(num < node.getKeys().get(i).getNum()) 
				return searchKey(node.getKeys().get(i).getPrevNode(), num);
			else if (num == node.getKeys().get(i).getNum())
				return node.getKeys().get(i);
		}
		return searchKey(node.getLastNode(), num);
	}
	
	public Node searchKeyNode(Node node, int num) {
		for(int i=0; i<node.getNumKeys(); i++) {
			if(num < node.getKeys().get(i).getNum()) 
				return searchKeyNode(node.getKeys().get(i).getPrevNode(), num);
			else if (num == node.getKeys().get(i).getNum())
				return node;
		}
		return searchKeyNode(node.getLastNode(), num);
	}
	
	
	//Delete
	public void delete(int num) {
		Node node = searchKeyNode(root, num);
		Key key = searchKey(root, num);
		Node prevNode = key.getPrevNode();
		int i = node.getKeys().indexOf(key);
		node.getKeys().remove(i);
		node.getKeys().get(i-1).getPrevNode().mergeNode(prevNode);
		node.setNumKeys(node.getNumKeys()-1);
	}
	
	
	//Find Predecessor Node
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
