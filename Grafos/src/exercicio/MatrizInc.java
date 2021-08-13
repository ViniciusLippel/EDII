package exercicio;

public class MatrizInc{
	
	private int[][] matrizInc;
	
	
	//Constructors
	public MatrizInc(int arestas, int vertices) {
		this.matrizInc = new int[arestas][vertices];
		for(int i=0; i<vertices; i++) {
			for(int j=0; j<arestas; j++) {
				matrizInc[j][i] = 0;
			}
		}
	}
	
	public MatrizInc(int[][] matrizInc) {
		this.matrizInc = matrizInc;
	}
	
	
	//Getters & Setters
	public int[][] getMatrizInc() {
		return matrizInc;
	}

	public void setMatrizInc(int[][] matrizInc) {
		this.matrizInc = matrizInc;
	}

	
	//Mostrar
	public String mostrar() {
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<this.matrizInc.length; j++) {
			for(int i=0; i<this.matrizInc[j].length; i++) {
				sb.append(this.matrizInc[j][i]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
