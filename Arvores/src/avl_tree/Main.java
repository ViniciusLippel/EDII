package avl_tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree a = new AVLTree();
		a.insert(10);
		a.insert(7);
		a.insert(11);
		a.insert(12);
		a.insert(8);
		a.insert(5);
		a.insert(9);
		a.insert(4);
		//a.insert(2);
		//a.delete(7);
		
		AVLTree b = new AVLTree();
		b.insert(10);
		b.insert(7);
		b.insert(11);
		b.insert(12);
		b.insert(8);
		b.insert(5);
		b.insert(9);
		b.insert(4);
		
		AVLTree c = new AVLTree();
		AVLTree d = new AVLTree();
		
		//System.out.println(a.findNode(a.getRoot(), 5).getNum());
		//System.out.println(a.verifyBalance(a.getRoot()));
		//System.out.println(a.isIdentical(b));
		System.out.println(a.nodesByLevel());
	}

}
