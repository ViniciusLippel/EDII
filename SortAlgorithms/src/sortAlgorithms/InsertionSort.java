package sortAlgorithms;

public class InsertionSort {
	
	public int[] sort(int[] v) {
		long comp = 0;
		long troc = 0;
		for (int i=0; i<v.length; i++) {
			//Pivo
			int pivo = v[i];
			int j = i - 1;
			//Comparação
			while (j>=0 && v[j]>pivo) {
				comp++;
				//Troca
				troc++;
				v[j+1] = v[j];
				j = j - 1;
			}
			//Troca
			v[j+1] = pivo;
		}
		System.out.println(comp+" comparacoes");
		System.out.println(troc+" trocas");
		return v;
	}
}

