package sortAlgorithms;

public class SelectionSort {
	
	private int[] v;
	
	public SelectionSort(int[] v) {
		this.v = v;
	}
	
	public int[] sort() {
		for (int i=0; i<this.v.length-1; i++) {
			int min = i;
			for (int j=i+1; j<this.v.length; j++) {
				if (this.v[j] < this.v[min])
					min = j;
			}
			int aux = this.v[i];
			this.v[i] = this.v[min];
			this.v[min] = aux;
		}
		return this.v;
	}
}
