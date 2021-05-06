package sortAlgorithms;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {3,7,4,5,2,10,2,42};
	    
		//Instanciando algoritmos de ordena��o
		
		//Bubble Sort
		BubbleSort bs = new BubbleSort(v);
		
		//Selection Sort
		SelectionSort ss = new SelectionSort(v);
		
		//Insertion Sort
		InsertionSort is = new InsertionSort(v);
		
		//Merge Sort (no momento fazendo apenas para ArrayList)
		MergeSort ms = new MergeSort();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i=0; i<v.length; i++)
			a.add(v[i]);
		/*a = ms.sort(a);
		System.out.println(a.toString());*/
		
		//Quick Sort
		QuickSort qs = new QuickSort();
		
		v = qs.sort(v, 0, v.length-1);
		System.out.println(Arrays.toString(v));
		
		
	}
}
