package sortAlgorithms;

public class BubbleSort {
	
	public int[] sort(int[] v){
		int comp = 0;
		long troc = 0;
		for (int i=0; i<v.length; i++) {
			for (int j=0; j<v.length-1; j++) {
			//Comparação
			comp++;
			if (v[j] > v[j+1]) {
				//Troca
				int aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
				troc++;
				}
			}
		}
		System.out.println(comp+" comparacoes");
		System.out.println(troc+" trocas");
		return v;
	}
}


