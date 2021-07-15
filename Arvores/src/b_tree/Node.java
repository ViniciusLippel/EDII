package b_tree;

import java.util.ArrayList;

public class Node {
	
	private int numKeys;
	private ArrayList<Key> keys;
	private Node lastNode;
	
	public Node() {
		this.numKeys = 0;
		this.keys = new ArrayList<Key>();
	}
	
	public int getNumKeys() {
		return numKeys;
	}
	public void setNumKeys(int numKeys) {
		this.numKeys = numKeys;
	}
	public ArrayList<Key> getKeys() {
		return keys;
	}
	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}
	public Node getLastNode() {
		return lastNode;
	}
	public void setLastNode(Node lastNode) {
		this.lastNode = lastNode;
	}
	
	public void addKey(int num) {
		Key k = new Key(num);
		if(this.numKeys != 0) {
			for(int i = 0; i<this.numKeys; i++) {
				int aux = this.keys.get(i).getNum();
				if(k.getNum() < aux) {
					this.keys.get(i).setNum(k.getNum());
					k = new Key(aux);
				}
			}
		}
		this.keys.add(k);
		this.numKeys++;
	}
	
	public void addPromoted(Node node) {
		if(node.getKeys().get(0).getNum() > this.getKeys().get(this.getNumKeys()-1).getNum()) {
			this.getKeys().add(node.getKeys().get(0));
			this.lastNode = node.getLastNode();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [numKeys=");
		builder.append(numKeys);
		builder.append(",keys=");
		builder.append(keys.toString());
		builder.append(",lastNode=");
		builder.append(lastNode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
