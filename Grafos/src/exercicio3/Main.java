package exercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int menu = -1;
		while(menu != 0) {
			System.out.println("1 - Novo Grafo \n2 - Inserir Arestas \n3 - Remover Arestas \n4 - Mostrar Representção \n0 - Finalizar");
			menu = sc.nextInt();
			
			GrafoI grafo = new MatrizAdjacencia(0, false);
			
			if(menu == 1)
				grafo = criarGrafo();
			else if (menu == 2)
				grafo = inserirArestas(grafo);
			System.out.print("\nGrafo:");
			grafo.mostrar();
			
			grafo.removerAresta(1, 3);
		}
		sc.close();
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
