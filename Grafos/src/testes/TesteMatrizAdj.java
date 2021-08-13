package testes;

import exercicio.*;

public class TesteMatrizAdj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MatrizAdj a = new MatrizAdj (5, true);
		
		a.inserirAresta(0, 1);
		a.inserirAresta(0, 4);
		a.inserirAresta(1, 2);
		//a.inserirAresta(1, 3);
		a.inserirAresta(2, 0);
		a.inserirAresta(2, 3);
		a.inserirAresta(2, 4);
		a.inserirAresta(3, 0);
		a.inserirAresta(3, 4);
		//a.inserirAresta(4, 1);
		
		a.removerAresta(3,  4);
		//a.removerAresta(1, 2);
		
		System.out.println("Matiz de Adjac�ncia:");
		System.out.println(a.mostrar());
		
		System.out.print("N�mero de arestas: ");
		System.out.println(a.numArestas());
		
		//Gera��o de matriz de incid�ncia funcionando apenas para grafos direcionados
		if(a.isDirecionado()) {
			System.out.println("\nGerando matriz de incid�ncia: ");
			System.out.println(a.gerarMatrizInc().mostrar());
		}
			
		System.out.println("\nGrafo completo?");
		System.out.println(a.grafoCompleto());
	}

}
