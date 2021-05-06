package sortAlgorithms;

public class QuickSort {
	
	public int[] sort(int[] a, int beg, int end) {
		if (beg < end) {
			int partIndex = partition(a, beg, end);
			
			sort(a, beg, partIndex-1);
			sort(a, partIndex+1, end);
		}
		
		return a;
	}
	
	public int partition (int[] a, int beg, int end){
		int pivot = a[end];
		int i = (beg-1);
		
		for(int j = beg; j < end; j++) {
			if(a[j] <= pivot) {
				i++;
				
				int swapTemp = a[i];
				a[i] = a[j];
				a[j] = swapTemp;
			}
		}
		
		int swapTemp = a[i+1];
		a[i+1] = a[end];
		a[end] = swapTemp;
		
		return i+1;
	}
}
