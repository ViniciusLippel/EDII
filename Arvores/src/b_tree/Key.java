package b_tree;

/* Classe Key:
 * Representa uma chave, um nodo é formado de várias chaves.
 * Armazena: 
 * 	- Nodo filho à esquerda 
 * 	- Número inteiro.
 */
public class Key {
	
	/*
	 * Atributos
	 */
	private Node prevNode;
	private int num;
	
	/*
	 * Construtor
	 */
	public Key(int num) {
		this.num = num;
	}
	
	/*
	 * Getters & Setters
	 */
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	/*
	 * To String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Key [prevNode=");
		builder.append(prevNode);
		builder.append(", num=");
		builder.append(num);
		builder.append("]");
		return builder.toString();
	}
	
}
