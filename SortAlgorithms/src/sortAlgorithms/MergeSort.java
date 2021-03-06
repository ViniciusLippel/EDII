package sortAlgorithms;
import java.util.ArrayList;

public class MergeSort {
	
	int comp = 0;
	int troc = 0;
	
	public ArrayList<Integer> sort(ArrayList<Integer> a) {
		
		if (a.size() == 1) {
			return a;
		}
		
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		for (int i=0;i<a.size()/2; i++)
			arr1.add(a.get(i));
		
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (int i=a.size()/2; i<a.size(); i++)
			arr2.add(a.get(i));
		
		arr1 = sort(arr1);
		arr2 = sort(arr2);
		
		return merge(arr1, arr2);
		//return a;
	}
	
	public ArrayList<Integer> merge (ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		while (a.size() != 0 && b.size() != 0) {
			//Comparação
			this.comp++;
			if (a.get(0) > b.get(0)) {
				//Troca
				this.troc++;
				c.add(b.get(0));
				b.remove(0);
			}
			else {
				//Troca
				this.troc++;
				c.add(a.get(0));
				a.remove(0);
			}
		}
		
		while (a.size() != 0) {
			c.add(a.get(0));
			a.remove(0);
		}
		
		while (b.size() != 0) {
			c.add(b.get(0));
			b.remove(0);
		}
		
		return c;
	}
	
	public ArrayList<Integer> arrToList(int[] v) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i=0; i<v.length; i++)
			a.add(v[i]);
		
		return a;
	}

}
