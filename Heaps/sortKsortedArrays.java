package HeapsandHashmap;
import java.util.*;
public class Sort_kSorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]= {2,3,1,4,6,7,5,8,9};
           sortksorted(arr,2);
           for(int val:arr) {
           System.out.print(val+" ");}
	}
	
	//sort time O(n log(k) )
	static void sortksorted(int arr[],int k) {
		
		//will filter elements of arr using pqueue
	  //using priority queue made in heap_implementation class
		PriorityQueue filter=new PriorityQueue();
		
		for(int i=0;i<k+1;i++) {
			filter.add(arr[i]);
			
		}
		int ind=0;
		for(int i=k+1;i<arr.length;i++) {
             arr[ind]=filter.remove();
             filter.add(arr[i]);
             ind++;
		}
		while(filter.size()>0) {
			arr[ind]=filter.remove();
			ind++;
		}
		
		
		
	}

}
