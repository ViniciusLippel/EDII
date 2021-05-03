package sortAlgorithms;

public class BubbleSort {
	
	private int[] v;
	
	public BubbleSort(int[] v){
	  this.v = v;
	}
	
	public int[] sort(){
	  for (int i=0; i<this.v.length; i++) {
	    for (int j=0; j<this.v.length-1; j++) {
	      if (this.v[j] > this.v[j+1]) {
	        int aux = this.v[j];
	        this.v[j] = this.v[j+1];
	        this.v[j+1] = aux;
	      }
	    }
	  }
	
	  return this.v;
	}
}
