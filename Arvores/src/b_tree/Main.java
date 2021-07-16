package b_tree;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//Árvore
		BTree b = new BTree(5);
		//10 e 20 ficarão no nodo raiz
		b.insert(10);
		b.insert(20);
		
		//Nodo mais à esquerda (armazenado na chave 10)
		Node left = new Node();
		Key k1 = new Key(3);
		Key k2 = new Key(6);
		ArrayList<Key> keys = new ArrayList<Key>();
		keys.add(k1);
		keys.add(k2);
		left.setKeys(keys);
		left.setNumKeys(2);
		
		//Nodo ao meio (armazenado na chave 20)
		Node middle = new Node();
		k1 = new Key(13);
		keys = new ArrayList<Key>();
		keys.add(k1);
		keys.add(k2);
		middle.setKeys(keys);
		middle.setNumKeys(2);
		
		//Nodo mais à direita (armazenado no nodo raiz)
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
		
		//Mostrando árvore
		System.out.println(b.toString());
		
		//Inserindo 16
		b.insert(16);
		System.out.println(b.toString());
		
		//Deletando 20
		b.delete(20);
		System.out.println(b.toString());
		
		//Buscando 3
		System.out.println(b.searchKey(b.getRoot(), 3));
	}

}
