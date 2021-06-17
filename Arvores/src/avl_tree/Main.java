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
		//a.delete(7);
		System.out.println(a.height(a.findNode(a.getRoot(), 7)));
	}

}
