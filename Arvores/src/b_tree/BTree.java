package b_tree;

import java.util.ArrayList;

/*
 * Classe BTree:
 * Classe que estrutura a árvore B.
 * 
 * Armazena:
 * 	- Ordem da árvore
 * 		> Número de filhos que cada nodo pode ter
 * 	- Nodo raiz
 */
public class BTree {
	
	/*
	 * Atributos
	 */
	private int order;
	private Node root;
	
	/*
	 * Construtor
	 * 	- Ao instanciar a árvore deve ser informada a ordem.
	 */
	public BTree(int order) {
		this.order = order;
	}
	
	/*
	 * Getters & Setters
	 */
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
	
	
	/* 
	 * Método insert:
	 *  - Recebe um valor inteiro
	 * 	- Verifica se a árvore já possui raiz
 * 			> Se sim, busca o nodo e adiciona o valor
 * 			> Senão, cria nodo raiz com o valor
	 */
	public void insert(int num) {
		if (this.root != null) {
			addInNode(findNode(this.root, num), num);
		}
		else {
			this.root = new Node();
			root.addKey(num);
		}
	}
	
	/*
	 * Método addInNode:
	 *  - Recebe o o nodo onde será armazenado e o valor
	 *  - Chama a função addKey do nodo
	 */
	public void addInNode(Node node, int num) {
		node.addKey(num);
	}
	
	/*
	 * Método findNode:
	 *  - Busca e retorna o nodo onde o valor será armazenado.
	 *  - Recebe o nodo onde será iniciada a busca e o valor.
	 */
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
	
	
	/*
	 * Método searchKey:
	 *  - Busca e retorna a chave onde está armazenado determinado valor
	 *  - Recebe o nodo onde será iniciada a busca e o valor.
	 */
	public Key searchKey(Node node, int num) {
		for(int i=0; i<node.getNumKeys(); i++) {
			if(num < node.getKeys().get(i).getNum()) 
				return searchKey(node.getKeys().get(i).getPrevNode(), num);
			else if (num == node.getKeys().get(i).getNum())
				return node.getKeys().get(i);
		}
		return searchKey(node.getLastNode(), num);
	}
	
	/*
	 * Método searchKeyNode:
	 *  - Busca e retorna o nodo onde determinada chave está armazenada
	 *  - Recebe o nodo onde será iniciada a busca e o valor.
	 */
	public Node searchKeyNode(Node node, int num) {
		for(int i=0; i<node.getNumKeys(); i++) {
			if(num < node.getKeys().get(i).getNum()) 
				return searchKeyNode(node.getKeys().get(i).getPrevNode(), num);
			else if (num == node.getKeys().get(i).getNum())
				return node;
		}
		return searchKeyNode(node.getLastNode(), num);
	}
	
	
	/*
	 * Método delete:
	 *  - Deleta a chave de um determinado valor
	 *  - Recebe o valor da chave que será deletada
	 *  - Chama o método 
	 */
	public void delete(int num) {
		Node node = searchKeyNode(root, num);
		Key key = searchKey(root, num);
		Node prevNode = key.getPrevNode();
		int i = node.getKeys().indexOf(key);
		node.getKeys().remove(i);
		node.getKeys().get(i-1).getPrevNode().mergeNode(prevNode);
		node.setNumKeys(node.getNumKeys()-1);
	}
	
	
	/*
	 * Método split:
	 * 	- Divide um nodo cheio em dois nodos
	 * 	- Recebe nodo a ser dividido
	 * 	- Retorna valor que deve ser promovido
	 */
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
	
	
	
	
	/*
	 * To String
	 */
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
