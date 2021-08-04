package exercicio3;

public class ListaAdjacencia implements GrafoI {
	
	protected class vertice {
		int num;
		vertice prox;
	}
	
	private vertice listaAdj[];
	private int qtdVertices;
	private boolean direcionado;
	
	public ListaAdjacencia(int qtdVertices, boolean direcionado) {
		this.qtdVertices = qtdVertices;
		listaAdj = new vertice[qtdVertices];
		this.direcionado = direcionado;
	}
	
	@Override
	public void inserirAresta(int origem, int destino) {
		vertice novo = new vertice();
		novo.num = destino;
		novo.prox = listaAdj[origem];
		listaAdj[origem] = novo;
		
		//para grafos nao direcionados
		novo = new vertice();
		novo.num = origem;
		novo.prox = listaAdj[destino];
		listaAdj[destino] = novo;
	}
	
	@Override
	public void removerAresta(int origem, int destino) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrar() {
		vertice v;
		for (int i=0; i<qtdVertices; i++) {
			v = listaAdj[i];
			System.out.println("V[ertice " + i + " ");
			while (v != null) {
				System.out.println("(" + i + ", " + v.num + ")" + " ");
				v = v.prox;
			}
		}
	}
	
	public vertice[] getLista() {
		return this.listaAdj;
	}
	
	public int getQtdVertices() {
		return this.qtdVertices;
	}

	
}
