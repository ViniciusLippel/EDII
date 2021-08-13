package testes;

import exercicio.*;

public class TesteListaAdj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListaAdj a = new ListaAdj (5, true);
		
		a.inserirAresta(0, 1);
		a.inserirAresta(0, 4);
		a.inserirAresta(1, 2);
		//a.inserirAresta(1, 3);
		a.inserirAresta(2, 0);
		a.inserirAresta(2, 3);
		a.inserirAresta(2, 4);
		a.inserirAresta(3, 0);
		//a.inserirAresta(3, 4);
		a.inserirAresta(4, 1);
		
		a.removerAresta(4,  1);
		//a.removerAresta(1, 2);
		
		System.out.println("Matiz de Adjacência:");
		System.out.println(a.mostrar());
		
		System.out.print("Número de arestas: ");
		System.out.println(a.numArestas());
		
		int v1 = 2;
		System.out.println("\nLista de adjacência do vértice "+v1+":");
		System.out.println(a.adjacentesVertice(v1));
		
		int v2 = 4;
		System.out.println("\nLista do vértice "+v2+" vazia?");
		System.out.println(a.listaAdjVazia(v2));
		
		//Geração de matriz de incidência funcionando apenas para grafos direcionados
		if(a.isDirecionado()) {
			System.out.println("\nGerando matriz de incidência: ");
			System.out.println(a.gerarMatrizInc().mostrar());
		}
			
		System.out.println("\nGrafo completo?");
		System.out.println(a.grafoCompleto());
		
	}

}
