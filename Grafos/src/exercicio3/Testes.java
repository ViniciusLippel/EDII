package exercicio3;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrizAdjacencia a = new MatrizAdjacencia (5, true);
		a.inserirAresta(1, 2);
		a.inserirAresta(3, 2);
		a.inserirAresta(3, 4);
		a.removerAresta(3,  2);
		a.mostrar();
	}

}
