package exercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoI grafo = criarGrafo();
		grafo = inserirArestas(grafo);
		System.out.println("\nGrafo:");
		grafo.mostrar();
	}
	
	@SuppressWarnings("resource")
	public static GrafoI criarGrafo() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Criando novo grafo... \n");
		
		System.out.println("Representar por: \n"+"1 - Matriz de Ajacência \n"+"2 - Lista de Ajacência");
		int rep = sc.nextInt();
		
		System.out.println("\nNúmero de vértices:");
		int numV = sc.nextInt();
		
		System.out.println("\nGrafo direcionado? (s/n)");
		String d = sc.next();
		boolean dir = false;
		if(d == "s")
			dir = true;
		
		if(rep == 1) {
			MatrizAdjacencia grafo = new MatrizAdjacencia (numV, dir);
			return grafo;
		}
		
		else if(rep == 2) {
			ListaAdjacencia grafo = new ListaAdjacencia (numV, dir);
			return grafo;
		}
		
		sc.close();
		
		return null;
	}
	
	public static GrafoI inserirArestas(GrafoI grafo) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nInserir arestas: (0 para finalizar)");
		
		int origem = -1;
		int destino = -1;
		
		while (origem != 0 && destino != 0) {
			System.out.println("---");
			System.out.print("Origem: ");
			origem = sc.nextInt();
			if(origem != 0) {
				System.out.print("Destino: ");
				destino = sc.nextInt();
				grafo.inserirAresta(origem, destino);
			}
		}
		
		sc.close();
		return grafo;
	}
	
	public static GrafoI removerArestas(GrafoI grafo) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nInserir arestas: (0 para finalizar)");
		
		int origem = -1;
		int destino = -1;
		
		while (origem != 0 && destino != 0) {
			System.out.println("---");
			System.out.print("Origem: ");
			origem = sc.nextInt();
			if(origem != 0) {
				System.out.print("Destino: ");
				destino = sc.nextInt();
				grafo.inserirAresta(origem, destino);
			}
		}
		
		sc.close();
		return grafo;
	}

}
