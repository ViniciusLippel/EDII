package b_tree;

import java.util.ArrayList;

public class Node {
	
	private int numKeys;
	private ArrayList<Key> keys;
	private Node lastNode;
	
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [numKeys=");
		builder.append(numKeys);
		builder.append(", keys=");
		builder.append(keys);
		builder.append(", lastNode=");
		builder.append(lastNode);
		builder.append("]");
		return builder.toString();
	}
	
	
}
