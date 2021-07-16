package b_tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTree b = new BTree(3);
		b.insert(5);
		b.insert(8);
		b.insert(7);
		b.insert(6);
		b.insert(3);
		
		BTree a = new BTree(5);
		a.insert(7);
		a.insert(8);
		
		System.out.println(b.toString());
		
		/*Node l = b.getRoot().getKeys().get(0).getPrevNode();
		Node r = b.getRoot().getLastNode();
		l.mergeNode(r);
		System.out.println(l);*/
		
		//System.out.println(b.searchKey(b.getRoot(), 6));
		
		//System.out.println(b.findPredNode(b.getRoot(), b.getRoot().getLastNode()));
		
		//System.out.println(b.findNode(b.getRoot(), 2));
		//b.insert(2);
		//b.insert(9);
		//b.insert(10);
		//System.out.println(b.findNode(b.getRoot(), 11));
		
		//b.split(b.getRoot());
		
		/*BTree b = new BTree(5);
		b.insert(23);
		
		Node left = new Node();
		left.addKey(7);
		left.addKey(10);
		
		Node middle1 = new Node();
		middle1.addKey(25);*/
	}

}
