package exercicio;

public class MatrizAdj{
	
	private int[][] matrizAdj;
	private boolean direcionado;
	
	
	//Constructor
	public MatrizAdj(int qtdVertices, boolean direcionado) {
		matrizAdj = new int[qtdVertices][qtdVertices];
		this.direcionado = direcionado;
	}
	
	
	//Getters & Setters
	public int[][] getMatrizAdj() {
		return matrizAdj;
	}

	public void setMatrizAdj(int[][] g) {
		matrizAdj = g;
	}

	public boolean isDirecionado() {
		return direcionado;
	}

	public void setDirecionado(boolean direcionado) {
		this.direcionado = direcionado;
	}


	//Inserir Aresta
	public void inserirAresta(int origem, int destino) {
		matrizAdj[origem][destino] = 1;
		if(!this.direcionado)
			matrizAdj[destino][origem] = 1;		
	}
	
	
	//Remover Aresta
	public void removerAresta(int origem, int destino) {
		matrizAdj[origem][destino] = 0;
		if(!this.direcionado)
			matrizAdj[destino][origem] = 0;	
	}
	
	
	//Número de arestas
	public int numArestas() {
		int soma = 0;
		for(int i=0; i<this.matrizAdj.length; i++) {
			for(int j=0; j<this.matrizAdj[i].length; j++) {
				if(matrizAdj[i][j] == 1)
					soma++;
			}
		}
		if(!this.direcionado)
			return soma/2;
		return soma;
	}
	
	
	//Verificar se é grafo completo
	public boolean grafoCompleto() {
		if((this.numArestas()*2) == ((this.matrizAdj.length-1)*this.matrizAdj.length))
			return true;
		return false;
	}
	
	
	//Mostrar
	public String mostrar() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<matrizAdj.length; i++) {
			for (int j=0; j<matrizAdj.length; j++) {
				sb.append(matrizAdj[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	//Gerar matriz de incidência (apenas para grafos direcionados)
	public MatrizInc gerarMatrizInc() {
		
		int [][] matrizInc = new int[this.numArestas()][this.matrizAdj.length];
		for(int i=0; i<this.numArestas(); i++) {
			for(int j=0; j<this.matrizAdj.length; j++) {
				matrizInc[i][j] = 0;
			}
		}
		
		int aresta = 0;
		for(int i=0; i<this.matrizAdj.length; i++) {
			for(int j=0; j<this.matrizAdj[i].length; j++) {
				if(this.matrizAdj[i][j] == 1) {
					matrizInc[aresta][i] = -1;
					matrizInc[aresta][j] = 1;
					aresta++;
				}
			}
		}
		
		MatrizInc mi = new MatrizInc(matrizInc);
		return mi;
	}
}
