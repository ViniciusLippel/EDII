package b_tree;

import java.util.ArrayList;

/* Classe Node:
 * Representa o nodo.
 * 
 * Armazena:
 * 	- N�mero de chaves
 * 	- ArrayList de chaves
 * 	- �ltimo nodo (nodo filho mais � direita)
 */

public class Node {
	
	/*
	 * Atributos
	 */
	private int numKeys;
	private ArrayList<Key> keys;
	private Node lastNode;
	
	/*
	 * Construtor
	 */
	public Node() {
		this.numKeys = 0;
		this.keys = new ArrayList<Key>();
	}
	
	/*
	 * Getters & Setters
	 */
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
	
	/* 
	 * M�todo addKey:
	 * 	- Recebe um n�mero inteiro, cria uma chave e armazena no nodo
	 */
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
	
	/* 
	 * M�todo mergeNode:
	 * 	- Funde o nodo atual com outro nodo (n�o verifica se est� ordenado)
	 */
	public void mergeNode(Node node) {
		if(node != null) {
			for(int i=0; i<node.getNumKeys(); i++) {
				keys.add(node.getKeys().get(i));
			}
		}
	}
	
	/*
	 * To String
	 */
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
