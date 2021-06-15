package avl_tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree a = new AVLTree();
		a.insert(10);
		a.insert(13);
		a.insert(8);
		a.insert(9);
		System.out.println(a.getRoot().getLeft().getRight().getNum());
	}

}
