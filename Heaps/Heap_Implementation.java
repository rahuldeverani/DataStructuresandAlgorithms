package HeapsandHashmap;

import java.util.*;

class PriorityQueue {

	ArrayList<Integer> data;

	public PriorityQueue() {

		data = new ArrayList<>();
	}

	public int size() {
		return data.size();
	}

	public void printQueue() {
		for (int val : data) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public int peek() {
		if (data.size() == 0) {
			System.out.println("Underflow");
			return -1;
		}

		return data.get(0);

	}

//add O(logn)	
	public void add(int val) {
		data.add(val);
		upheapify(data.size() - 1);

	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;
		if (data.get(pi) > data.get(ci)) {
			swap(ci, pi);
			upheapify(pi);
		}

	}

//O(logn)
	public int remove() {
		if (data.size() == 0) {
			System.out.println("underflow");
			return -1;
		}
	
		swap(0, data.size() - 1);
		int retval = data.get(data.size() - 1);
		data.remove(data.size()-1);
		downheapify(0);
		return retval;

	}

	private void downheapify(int curInd) {

		int leftChildInd = 2 * curInd + 1;
		int rightChildInd = 2 * curInd + 2;
		int miniind = curInd;

		if (leftChildInd <= data.size() - 1 && data.get(leftChildInd) < data.get(miniind)) {
			miniind = leftChildInd;

		}
		if (rightChildInd <= data.size() - 1 && data.get(rightChildInd) < data.get(miniind)) {
			miniind = rightChildInd;

		}
		if (miniind != curInd) {
			swap(curInd, miniind);
			downheapify(miniind);
		}

	}

	private void swap(int ci, int pi) {

		int cival = data.get(ci);
		int pival = data.get(pi);
		data.set(ci, pival);
		data.set(pi, cival);

	}

}

public class Heap_Implementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue myqueue = new PriorityQueue();
		//testing by sortng this using heapsort
		int arr[] = { 100,32,812,23,0,78,82,9120,50,2,10,77};
		
		for(int val: arr) {
			myqueue.add(val);
		}
	    //after addition
		System.out.println("After Addition all values are ");
		myqueue.printQueue();
		System.out.println("sorting");
		while(myqueue.size()>0) {
			System.out.print(myqueue.remove()+" ");
			
		}
		
		///testing Kth largest
		int arr2[]= {13,12,62,22,15,37,99,11,37,98,67,31,84,999,4};
		//int arr2[]= {2,10,5,17,7,18,6,4};
		int arr3[]=kLargest(arr2,4);
		System.out.println();
		System.out.println("Printing K largest in arr2");
		for(int i=0;i<arr3.length;i++) {
			System.out.print(arr3[i]+" ");
		}
		
	}
	
	// Queue size will always be of log(k) as only k elements will be there in queue , so for n total O(nlogk)
	// space O(K)
	static int[] kLargest(int arr[], int k) {
		PriorityQueue queue=new PriorityQueue();
		
		for(int i=0;i<arr.length;i++) {
			if(queue.size()<k) {
				queue.add(arr[i]);
			}
			else {
				if(queue.peek()<arr[i]) {
					int p=queue.remove();
			
					queue.add(arr[i]);
					
				}
				
			}
			
		}
		int[] retvals=new int[k];
		int i=0;
		while(queue.size()>0) {
			retvals[i]=queue.remove();
			i++;
		}
		return retvals;
		
	}
	
	
	
	

}
