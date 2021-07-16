package b_tree;

import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree b = new BTree(5);
		
		b.insert(10);
		b.insert(20);
		
		Node left = new Node();
		Key k1 = new Key(3);
		Key k2 = new Key(6);
		ArrayList<Key> keys = new ArrayList<Key>();
		keys.add(k1);
		keys.add(k2);
		left.setKeys(keys);
		left.setNumKeys(2);
		
		Node middle = new Node();
		k1 = new Key(13);
		k2 = new Key(16);
		keys = new ArrayList<Key>();
		keys.add(k1);
		keys.add(k2);
		middle.setKeys(keys);
		middle.setNumKeys(2);
		
		Node right = new Node();
		k1 = new Key(24);
		k2 = new Key(26);
		keys = new ArrayList<Key>();
		keys.add(k1);
		keys.add(k2);
		right.setKeys(keys);
		right.setNumKeys(2);
		
		b.getRoot().getKeys().get(0).setPrevNode(left);
		b.getRoot().getKeys().get(1).setPrevNode(middle);
		b.getRoot().setLastNode(right);
		
		System.out.println(b.toString());
		b.delete(20);
		System.out.println(b.toString());
	}

}
