package sortAlgorithms;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {3,7,2,5,1,6,10};
	    
		BubbleSort bs = new BubbleSort(v);
		SelectionSort ss = new SelectionSort(v);
		InsertionSort is = new InsertionSort(v);
		
		v = is.sort();
		
	    for (int i=0; i<v.length; i++)
	    	System.out.println(v[i]+" ");
	}
}
