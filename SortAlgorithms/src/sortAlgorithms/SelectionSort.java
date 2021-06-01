package sortAlgorithms;

public class SelectionSort {
	
	public int[] sort(int[] v) {
		int comp = 0;
		int troc = 0;
		for (int i=0; i<v.length-1; i++) {
			int min = i;
			for (int j=i+1; j<v.length; j++) {
				//Comparação
				comp++;
				if (v[j] < v[min])
					min = j;
			}
			//Troca
			int aux = v[i];
			v[i] = v[min];
			v[min] = aux;
			troc++;
		}
		System.out.println(comp+" comparacoes");
		System.out.println(troc+" trocas");
		return v;
	}
}
