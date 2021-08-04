package exercicio3;

public class MatrizAdjacencia implements GrafoI {
	
	private int qtdVertices;
	private int[][]G;
	private boolean direcionado;
	
	public MatrizAdjacencia(int qtdVertices, boolean direcionado) {
		this.qtdVertices = qtdVertices;
		G = new int[qtdVertices+1][qtdVertices+1];
		this.direcionado = direcionado;
	}
	
	public void inserirAresta(int origem, int destino) {
		G[origem][destino] = 1;
		if(this.direcionado)
			G[destino][origem] = 1;		
	}
	
	public void removerAresta(int origem, int destino) {
		G[origem][destino] = 0;
		if(!direcionado)
			G[destino][origem] = 0;	
	}
	
	public void mostrar() {
		//i = linhas
		//j = colunas
		System.out.println();
		for (int i=1; i<G.length; i++) {
			for (int j=1; j<G.length; j++) {
				System.out.print(G[i][j] + " ");
			}
			System.out.println();
		}
	}
}
