package sortAlgorithms;

public class QuickSort {
	
	int comp = 0;
	int troc = 0;
	
	
	public int[] sort(int[] a, int beg, int end) {
		if (beg < end) {
			int partIndex = partition(a, beg, end);
			
			sort(a, beg, partIndex-1);
			sort(a, partIndex+1, end);
		}
		return a;
	}
	
	public int partition (int[] a, int beg, int end){
		int mid = beg + ((end-beg)/2);
		int pivot = a[mid];
		int i = (beg-1);
		
		for(int j = beg; j < end; j++) {
			//Comparação
			this.comp++;
			if(a[j] <= pivot) {
				i++;
				
				//Troca
				this.troc++;
				int swapTemp = a[i];
				a[i] = a[j];
				a[j] = swapTemp;
			}
		}
		
		//Troca
		this.troc++;
		int swapTemp = a[i+1];
		a[i+1] = a[end];
		a[end] = swapTemp;
		
		return i+1;
	}
}
