package exemplos;

public class MatrizAdjacencia {
	
	private int qtdVertices;
	private int[][]G;
	
	public MatrizAdjacencia(int qtdVertices) {
		this.qtdVertices = qtdVertices;
		G = new int[qtdVertices][qtdVertices];
	}
	
	public void inserirAresta(int origem, int destino) {
		//No caso de grafo nao direcionado
		G[origem][destino] = 1;
		G[destino][origem] = 1;		
	}
	
	public void removerAresta(int origem, int destino) {
		//No caso de grafo nao direcionado
		G[origem][destino] = 0;
		G[destino][origem] = 0;	
	}
	
	public void mostrarMatriz() {
		for (int i=0; i<G.length; i++) {
			for (int j=0; j<G.length; j++) {
				System.out.println(G[i][j] + " ");
			}
			System.out.println();
		}
	}
}
