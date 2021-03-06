package sortAlgorithms;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = 100000;
		
		//int[] v = {5,3,7,1};
 		
		//Instanciando algoritmos de ordena??o
		BubbleSort bs = new BubbleSort();
		SelectionSort ss = new SelectionSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		
		ZonedDateTime t1;
		ZonedDateTime t2;
	    int[] v;
	    
	    System.out.println("Tempo para ordenar vetor aleat?rio:\n");
	    
		v = gerarVetor(n);
		t1 = ZonedDateTime.now();
		v = bs.sort(v);
		t2 = ZonedDateTime.now();
		System.out.println("Bubble Sort: "+ChronoUnit.MILLIS.between(t1, t2)+"ms\n");
		
		v = gerarVetor(n);
		t1 = ZonedDateTime.now();
		v = ss.sort(v);
		t2 = ZonedDateTime.now();
		System.out.println("Selection Sort: "+ChronoUnit.MILLIS.between(t1, t2)+"ms\n");
		
		v = gerarVetor(n);
		t1 = ZonedDateTime.now();
		v = is.sort(v);
		t2 = ZonedDateTime.now();
		System.out.println("Insertion Sort: "+ChronoUnit.MILLIS.between(t1, t2)+"ms\n");
		
		v = gerarVetor(n);
		ArrayList<Integer> a = arrToList(v);
		t1 = ZonedDateTime.now();
		a = ms.sort(a);
		t2 = ZonedDateTime.now();
		System.out.println(ms.comp+" comparacoes");
		System.out.println(ms.troc+" trocas");
		System.out.println("Merge Sort: "+ChronoUnit.MILLIS.between(t1, t2)+"ms\n");
		v = listToArr(a);
		
		v = gerarVetor(n);
		t1 = ZonedDateTime.now();
		v = qs.sort(v, 0, v.length-1);
		t2 = ZonedDateTime.now();
		System.out.println(qs.comp+" comparacoes");
		System.out.println(qs.troc+" trocas");
		System.out.println("Quick Sort: "+ChronoUnit.MILLIS.between(t1, t2)+"ms");
		
		
	}
	
	public static int[] gerarVetor(int n) {
		int[] v = vetorAleatorio(n);
		return v;
	}
	
	public static int[] vetorAleatorio(int n) {
		int[] v = new int[n];
		Random rand = new Random();
		for (int i=0; i<n; i++) {
			v[i] = rand.nextInt(n);
		}
		
		return v;
	}
	
	public static int[] vetorInvertido(int n) {
		int[] v = new int[n];
		int j = n;
		for (int i=0; i<n; i++) {
			v[i] = j;
			j--;
		}
		
		return v;
	}
	
	public static int[] vetorOrdenado(int n) {
		int[] v = new int[n];
		for (int i=0; i<n; i++) {
			v[i] = i;
		}
		
		return v;
	}
	
	
	public static ArrayList<Integer> arrToList(int[] v) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i=0; i<v.length; i++)
			a.add(v[i]);
		
		return a;
	}
	
	public static int[] listToArr(ArrayList<Integer> a) {
		int[] v = new int[a.size()];
		for (int i=0; i<v.length; i++)
			v[i] = a.get(i);
		
		return v;
	}
}
