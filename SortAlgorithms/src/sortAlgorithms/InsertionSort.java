package sortAlgorithms;

public class InsertionSort {
	
	private int[] v;
	
	public InsertionSort(int[] v) {
		this.v = v;
	}
	
	public int[] sort() {
		for (int i=0; i<this.v.length; i++) {
			int pivo = this.v[i];
			int j = i - 1;
			while (j>=0 && this.v[j]>pivo) {
				this.v[j+1] = this.v[j];
				j = j - 1;
			}
			this.v[j+1] = pivo;
		}
		return this.v;
	}
}
