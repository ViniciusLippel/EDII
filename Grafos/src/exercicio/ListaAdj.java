package exercicio;

import java.util.ArrayList;

public class ListaAdj{
	
	private ArrayList<ArrayList<Integer>> listaAdj;
	private boolean direcionado;
	
	
	//Constructor
	public ListaAdj (int qtdVertices, boolean direcionado) {
		this.listaAdj = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<qtdVertices; i++)
			this.listaAdj.add(new ArrayList<Integer>());
		this.direcionado = direcionado;
	}
	
	
	//Getters & Setters
	public ArrayList<ArrayList<Integer>> getListaAdj() {
		return listaAdj;
	}
	
	public void setListaAdj(ArrayList<ArrayList<Integer>> listaAdj) {
		this.listaAdj = listaAdj;
	}

	public boolean isDirecionado() {
		return direcionado;
	}
	
	public void setDirecionado(boolean direcionado) {
		this.direcionado = direcionado;
	}


	//Inserir Aresta
	public void inserirAresta(int origem, int destino) {
		this.listaAdj.get(origem).add(destino);
		if(!this.direcionado)
			this.listaAdj.get(destino).add(origem);
	}

	
	//Remover Aresta
	public void removerAresta(int origem, int destino) {
		int index = this.listaAdj.get(origem).indexOf(destino);
		if(index != -1) {
			this.listaAdj.get(origem).remove(index);
			if(!this.direcionado) {
				index = this.listaAdj.get(destino).indexOf(origem);
				this.listaAdj.get(destino).remove(index);
			}
		}
	}
	
	
	//Retornar número de arestas
	public int numArestas() {
		int soma = 0;
		for(int i=0; i<this.listaAdj.size(); i++) 
			soma = soma + this.listaAdj.get(i).size();
		if(!this.direcionado)
			return soma / 2;
		return soma;
	}
	
	
	//Verificar se vértice possui adjacentes
	public boolean possuiAdjacentes(int vertice) {
		ArrayList<Integer> adjacentes = this.listaAdj.get(vertice);
		if(adjacentes.size() != 0)
			return true;
		return false;
	}
	
	
	//Verificar adjacentes de um vertice
	public String adjacentesVertice(int vertice) {
		StringBuilder sb = new StringBuilder();
		if(possuiAdjacentes(vertice)) {
			ArrayList<Integer> adjacentes = this.listaAdj.get(vertice);
			sb.append("Vértice "+vertice);
			for(int i=0; i<adjacentes.size(); i++) {
				sb.append(" -> "+adjacentes.get(i));
			}
		}
		else
			sb.append("Vértice "+vertice+" não possui adjacentes");
		
		return sb.toString();
	}
	
	
	//Retornar se lista de adjacencia de um vértice está vazia
	public boolean listaAdjVazia(int vertice) {
		if(!possuiAdjacentes(vertice))
			return true;
		return false;
	}
	
	
	//Verifica se é grafo completo
	public boolean grafoCompleto() {
		MatrizAdj ma = new MatrizAdj(this.listaAdj.size(), false);
		for(int i=0; i<this.listaAdj.size(); i++) {
			for(int j=0; j<this.listaAdj.get(i).size(); j++)
				ma.inserirAresta(i, this.listaAdj.get(i).get(j));
		}
		return ma.grafoCompleto();
	}
	
	//Mostrar
	public String mostrar() {		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<this.listaAdj.size(); i++) {
			sb.append("Vértice "+i);
			for(int j=0; j<this.listaAdj.get(i).size(); j++)
				sb.append(" -> "+this.listaAdj.get(i).get(j));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	//Gerar matriz de incidência (funcionando apenas para grafos direcionados)
	public MatrizInc gerarMatrizInc() {
		
		int [][] matrizInc = new int[this.numArestas()][this.listaAdj.size()];
		for(int i=0; i<this.numArestas(); i++) {
			for(int j=0; j<this.listaAdj.size(); j++) {
				matrizInc[i][j] = 0;
			}
		}
		
		int aresta = 0;
		for(int i=0; i<this.listaAdj.size(); i++) {
			if(this.possuiAdjacentes(i)){
				for(int j=0; j<this.listaAdj.get(i).size(); j++) {
					matrizInc[aresta][i] = -1;
					matrizInc[aresta][this.listaAdj.get(i).get(j)] = 1;
					aresta++;
				}
			}
		}
		
		MatrizInc mi = new MatrizInc(matrizInc);
		return mi;
	}
	
}
